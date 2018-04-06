import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Workbook} from '../../models/workbook.model';

@Component({
  selector: 'app-workbook-list',
  templateUrl: './workbook-list.component.html',
  styleUrls: ['./workbook-list.component.css']
})
export class WorkbookListComponent implements OnInit, OnChanges {

  @Input() public workbookList: Workbook[];
  @Input() public sort: string;

  constructor() {
  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['sort']) {
      console.log(this.sort);
    }
  }

}
