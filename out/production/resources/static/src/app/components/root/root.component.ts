import { Component, OnInit } from '@angular/core';
import {WorkbookService} from "../../services/workbook/workbook.service";
import {Workbook} from "../../models/workbook.model";

@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['./root.component.css']
})
export class RootComponent implements OnInit {

  public workbookList: Workbook[] = [];

  constructor(private workbookService: WorkbookService) {
  }

  ngOnInit() {
    this.workbookService.getWorkbookList().subscribe(data => {this.workbookList = data});
  }

}
