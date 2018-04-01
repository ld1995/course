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
    this.workbookService.getWorkbookList().subscribe(data => {this.workbookList = data; console.log(data)})
    // this.workbookList.push(new Workbook("ld1995",
    //   "text", "Текст для теста", "12345", "Текст (от лат. textus «ткань; сплетение, связь, сочетание») — зафиксированная на каком-либо материальном носителе человеческая мысль; в общем плане связная и полная последовательность символов.",
    //   new Date(), 3, [1,2,3], [1,2,3], ["lol", "kek"] ))
    // this.workbookList.push(new Workbook("ld1995",
    //   "text", "Текст для теста", "12345", "Текст (от лат. textus «ткань; сплетение, связь, сочетание») — зафиксированная на каком-либо материальном носителе человеческая мысль; в общем плане связная и полная последовательность символов.",
    //   new Date(), 3, [1,2,3], [1,2,3], ["lol"] ))
    // this.workbookList.push(new Workbook("ld1995",
    //   "text", "Текст для теста", "12345", "Текст (от лат. textus «ткань; сплетение, связь, сочетание») — зафиксированная на каком-либо материальном носителе человеческая мысль; в общем плане связная и полная последовательность символов.",
    //   new Date(), 3, [1,2,3], [1,2,3], ["lol"] ))
  }

  ngOnInit() {
  }

}
