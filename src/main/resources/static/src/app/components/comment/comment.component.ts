import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {CommentService} from '../../services/comment/comment.service';
import {CommentModel} from '../../models/comment.model';
import {onChildUpdated} from 'angularfire2/database-deprecated';
import {timer} from 'rxjs/observable/timer';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})

export class CommentComponent implements OnInit, OnChanges {

  @Input() comments: CommentModel[];
  @Input() workbookId: number;
  @Output() onUpdateRecursive: EventEmitter<CommentModel> = new EventEmitter<CommentModel>();

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['comments']) {
    }
  }

  public onUpdate(comment) {
    this.onUpdateRecursive.emit(comment);
  }

  public onUpdateChild(comment) {
    this.onUpdateRecursive.emit(comment);
  }
}
