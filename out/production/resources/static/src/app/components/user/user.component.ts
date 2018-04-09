import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth0/auth-service';
import {WorkbookService} from '../../services/workbook/workbook.service';
import {WorkbookModel} from '../../models/workbook.model';
import {FileModel} from '../../models/file.model';
import * as _ from 'lodash';
import {AngularFireDatabase} from 'angularfire2/database';
import * as firebase from 'firebase';
import {Ng2ImgMaxService} from 'ng2-img-max';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public workbook: WorkbookModel;
  public workbookList: WorkbookModel[] = [];
  public currentUpload: FileModel;
  public dropzoneActive = false;
  public progress: number;
  public sortedBy: string;
  public name: string;
  public numberSpecialty;
  public title: string;
  public content: string;

  constructor(private auth: AuthService, private workbookService: WorkbookService,
              private fireData: AngularFireDatabase, private ng2ImgMax: Ng2ImgMaxService) {
  }

  //todo validata запретить нажатие, если форма пуста
  ngOnInit() {
    this.cleanForm();
    this.getWorkbookListByUsername();
  }

  public clickHandler() {
    this.workbook.username = this.auth.userProfile.sub;
    this.workbook.name = this.name;
    this.workbook.title = this.title;
    this.workbook.numberSpecialty = this.numberSpecialty;
    this.workbook.content = this.content;
    this.workbook.id === undefined ? this.addWorkbook() : this.updateWorkbook();
  }

  private addWorkbook() {
    console.log(this.workbook);
    this.workbookService.addWorkbook(this.workbook).subscribe(data => {console.log(data); this.ngOnInit(); });
  }

  private updateWorkbook() {
    console.log(this.workbook);
    this.workbookService.updateWorkbook(this.workbook).subscribe( data => {console.log(data); this.ngOnInit(); });
  }

  public getWorkbookListByUsername() {
    this.workbookService.getWorkbookListByUsername(this.auth.sub).subscribe(data => this.workbookList = data);
  }

  public deleteWorkbook(id) {
    this.workbookService.deleteWorkbook(id).subscribe(data => {console.log(data); this.ngOnInit(); });
    this.ngOnInit();
  }

  public sort($event) {
     this.sortedBy = $event.target.getAttribute('data-sort');
  }

  private cleanForm() {
    this.workbook = new WorkbookModel();
    this.progress = 0;
    this.name = '';
    this.numberSpecialty = '';
    this.title = '';
    this.content = '';
  }

  public transferDataSuccess($event) {
    this.workbook = $event.dragData;
    const {name, numberSpecialty, title, content} = this.workbook;
    this.name = name;
    this.numberSpecialty = numberSpecialty;
    this.title = title;
    this.content = content;
  }

  dropzoneState($event: boolean) {
    this.dropzoneActive = $event;
  }

  handleDrop(fileList: FileList) {
    // debugger;
    const filesIndex = _.range(fileList.length);
    _.each(filesIndex, (idx) => {
      this.ng2ImgMax.resizeImage(fileList[idx], 450, 10000).subscribe(
        result => {
          this.currentUpload = new FileModel(result);
          this.pushUpload(this.currentUpload);
        });
    });
  }

  pushUpload(upload: FileModel) {
    const storageRef = firebase.storage().ref();
    const uploadTask = storageRef.child(`uploads/${upload.file.name}`).put(upload.file);

    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,
      (snapshot) =>  {
        // this.progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
      },
      (error) => {
        console.log(error);
      },
      () => {
        upload.url = uploadTask.snapshot.downloadURL;
        upload.name = upload.file.name;
        this.content += ` ![alt text](${upload.url} "${upload.name}")`;
        this.saveFileData(upload);
      }
    );
  }

  private saveFileData(upload: FileModel) {
    this.fireData.list(`uploads`).push(upload);
  }
}
