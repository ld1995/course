import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {AuthService} from '../../services/auth0/auth-service';
import {WorkbookModel} from '../../models/workbook.model';
import {WorkbookService} from '../../services/workbook/workbook.service';

@Component({
  selector: 'app-workbook',
  templateUrl: './workbook.component.html',
  styleUrls: ['./workbook.component.css']
})
export class WorkbookComponent implements OnInit, OnChanges {

  @Input() workbook: WorkbookModel;

  constructor(public auth: AuthService, private workbookService: WorkbookService) {
  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges) {
  }

  public accordionEvent($event: boolean) {

  }

  public onUpdate(comment) {
    this.workbookService.getCommentListByWorkbookId(this.workbook.id).subscribe( data => {
      this.workbook.comments = data; console.log(data);
    });
    // if (comment.parentId) {
    //   // console.log('add deep ' + comment);
    //   this.workbook.comments.find(x => x.id === comment.parentId).comments.push(comment);
    // } else {
    //   this.workbook.comments.push(comment);
    // }
  }
}
