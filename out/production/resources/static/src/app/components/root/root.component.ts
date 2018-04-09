import {Component, Inject, OnInit} from '@angular/core';
import {WorkbookService} from '../../services/workbook/workbook.service';
import {WorkbookModel} from '../../models/workbook.model';
import 'rxjs/add/operator/takeUntil';
import 'rxjs/add/operator/first';
import { timer } from 'rxjs/observable/timer';

@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['./root.component.css']
})
export class RootComponent implements OnInit {

  public workbookList: WorkbookModel[] = [];

  constructor(private workbookService: WorkbookService) {
  }

  ngOnInit() {
    this.workbookService.getWorkbookList().subscribe(data => {this.workbookList = data; console.log(data); });
  }

}
