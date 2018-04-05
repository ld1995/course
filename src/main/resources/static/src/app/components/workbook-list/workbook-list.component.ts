import {Component, Input, OnInit} from '@angular/core';
import {Workbook} from '../../models/workbook.model';

@Component({
  selector: 'app-workbook-list',
  templateUrl: './workbook-list.component.html',
  styleUrls: ['./workbook-list.component.css']
})
export class WorkbookListComponent implements OnInit {

  @Input() public workbookList: Workbook[];

  constructor() {
  }

  ngOnInit() {

  }

}
