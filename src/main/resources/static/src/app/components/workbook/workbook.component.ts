import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthService} from "../../services/auth-service";
import {Workbook} from "../../models/workbook.model";
import {AccordionConfig} from "ngx-bootstrap";

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
