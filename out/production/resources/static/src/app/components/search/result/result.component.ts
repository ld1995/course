import { Component, OnInit } from '@angular/core';
import {Workbook} from "../../../models/workbook.model";
import {SearchDataService} from "../../../services/search/search-data.service";
import {SearchService} from "../../../services/search/search.service";

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css'],
})
export class ResultComponent implements OnInit {

  title: string;

  public workbookList: Workbook[];

  constructor(private searchService: SearchService) {
  }

  ngOnInit() {
    window.location.reload();
    this.workbookList = this.searchService.data;
    if(this.workbookList.length === 0) {
      this.title = 'Тебе не повезло, попробуй ещё разочек :-)'
    } else {
      this.title = 'Успех!!!'
    }
  }

}
