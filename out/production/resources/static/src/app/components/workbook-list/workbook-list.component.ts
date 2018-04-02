import {Component, Input, OnInit} from '@angular/core';
import {WorkbookService} from "../../services/workbook/workbook.service";
import {Workbook} from "../../models/workbook.model";
import {Tag} from "../../models/tag.model";
import {AccordionConfig} from "ngx-bootstrap";

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

// export function getAccordionConfig(): AccordionConfig {
//   return Object.assign(new AccordionConfig(), { closeOthers: true });
// }
