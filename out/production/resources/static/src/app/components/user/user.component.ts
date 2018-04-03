import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth0/auth-service';
import {WorkbookService} from '../../services/workbook/workbook.service';
import {Workbook} from '../../models/workbook.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  content: string;
  private workbook: Workbook;

  constructor(private auth: AuthService, private workbookService: WorkbookService) { }

  ngOnInit() {
  }

  public createUser() {
    this.workbook = new Workbook();
    this.workbookService.createWorkbook(this.workbook).subscribe(data => console.log(data));
  }
}
