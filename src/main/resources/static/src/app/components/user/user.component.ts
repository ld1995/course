import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth0/auth-service';
import {WorkbookService} from '../../services/workbook/workbook.service';
import {Workbook} from '../../models/workbook.model';
import {Router} from '@angular/router';
import {Profile} from 'selenium-webdriver/firefox';
import {ProfileComponent} from '../profile/profile.component';

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

  constructor(private auth: AuthService, private workbookService: WorkbookService, private route: Router) {
    // this.getWorkbookListByUsername();
  }

  ngOnInit() {
    this.getWorkbookListByUsername();
  }

  public createWorkbook() {
    //todo validata
    this.workbook = new Workbook(this.auth.userProfile.sub,
      this.name, this.title, `${this.numberSpecialty}`, this.content);
    this.workbookService.createWorkbook(this.workbook).subscribe(data => console.log(data));
    this.cleanForm();
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
}
