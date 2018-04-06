import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth0/auth-service';
import {WorkbookService} from '../../services/workbook/workbook.service';
import {Workbook} from '../../models/workbook.model';
import {ProfileComponent} from '../profile/profile.component';
import {FileModel} from '../../models/file.model';
import * as _ from 'lodash';
import {AngularFireDatabase} from 'angularfire2/database';
import * as firebase from 'firebase';
import {Ng2ImgToolsService} from 'ng2-img-tools';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public content: string;
  public title: string;
  public name: string;
  public numberSpecialty;
  public workbook: Workbook;
  public workbookList: Workbook[] = [];
  private profile: ProfileComponent;
  public currentUpload: FileModel;
  public dropzoneActive = false;
  public progress: number;

  constructor(private auth: AuthService, private workbookService: WorkbookService,
              private fireData: AngularFireDatabase, private ng2ImgToolsService: Ng2ImgToolsService) {
  }

  ngOnInit() {
    this.cleanForm();
    this.getWorkbookListByUsername();
  }

  public createWorkbook() {
    //todo validata
    this.workbook = new Workbook(this.auth.userProfile.sub,
      this.name, this.title, `${this.numberSpecialty}`, this.content);
    this.workbookService.createWorkbook(this.workbook).subscribe(data => console.log(data));
    this.ngOnInit();
  }

  public getWorkbookListByUsername() {
    console.log(this.auth.userProfile.sub);
    this.workbookService.getWorkbookListByUsername(this.auth.userProfile.sub).subscribe(data => this.workbookList = data);
  }

  private cleanForm() {
    this.content = '';
    this.title = '';
    this.name = '';
    this.numberSpecialty = '';
  }

  dropzoneState($event: boolean) {
    this.dropzoneActive = $event;
  }

  handleDrop(fileList: FileList) {
    const filesIndex = _.range(fileList.length);
    this.ng2ImgToolsService.resize( Array.from(fileList), 250, 250).subscribe();
    _.each(filesIndex, (idx) => {
      this.currentUpload = new FileModel(fileList[idx]);
      this.pushUpload(this.currentUpload);
    });
  }

  pushUpload(upload: FileModel) {
    const storageRef = firebase.storage().ref();
    const uploadTask = storageRef.child(`uploads/${upload.file.name}`).put(upload.file);
    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,
      (snapshot) =>  {
        this.progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
      },
      (error) => {
        console.log(error);
      },
      () => {
        this.content = (this.content.concat(`![alt text](${uploadTask.snapshot.downloadURL} "${upload.file.name}")`));
        this.saveFileData(upload);
      }
    );
  }

  private saveFileData(upload: FileModel) {
    this.fireData.list(`uploads`).push(upload);
  }
}
