import {Component, Injectable, OnInit} from '@angular/core';
import {WorkbookModel} from '../../../models/workbook.model';
import {SearchService} from '../../../services/search/search.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css'],
})
@Injectable()
export class ResultComponent implements OnInit {
  public workbookList: WorkbookModel[] = [];

  constructor( private searchService: SearchService) {
  }

  ngOnInit() {
    this.workbookList = this.searchService.data;
  }

}
