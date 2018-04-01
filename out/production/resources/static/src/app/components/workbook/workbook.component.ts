import {Component, Input, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth-service";
import {Workbook} from "../../models/workbook.model";

@Component({
  selector: 'app-workbook',
  templateUrl: './workbook.component.html',
  styleUrls: ['./workbook.component.css']
})
export class WorkbookComponent implements OnInit {

  @Input() workbook: Workbook;

  constructor(public auth: AuthService) { }

  ngOnInit() {
  }
}
