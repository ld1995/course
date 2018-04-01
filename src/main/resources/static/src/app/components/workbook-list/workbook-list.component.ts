import { Component, OnInit } from '@angular/core';
import {WorkbookService} from "../../services/workbook/workbook.service";
import {Workbook} from "../../models/workbook.model";
import {Tag} from "../../models/tag.model";

@Component({
  selector: 'app-workbook-list',
  templateUrl: './workbook-list.component.html',
  styleUrls: ['./workbook-list.component.css']
})
export class WorkbookListComponent implements OnInit {

  public workbookList: Workbook[] = [];

  constructor(private workbookService: WorkbookService) {
  }

  ngOnInit() {
    this.workbookService.getWorkbookList().subscribe(data => {this.workbookList = data; console.log(data)})
  }

}
