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

  constructor(private commentService: CommentService) { }

  ngOnInit() {
    // timer(1000, 2000).subscribe(val => {
    //     // this.commentService.getCommentById().subscribe(data => this.workbookList = data);
    //     console.log(123);
    //   }
    // );
    // Observable
    // // after 10s, tick every 5s
    //   .timer(10000, 5000)
    //   // stop this observable chain if stopTimer$ emits a value
    //   .takeUntil(stopTimer$)
    //   // select the model
    //   .map(_ => this.find(id))
    //   // do not go further unless the model has a property 'isActivated' truthy
    //   .filter(model => model['isActivated'])
    //   // only take one value so we don't need to manually unsubscribe
    //   .first()
    //   .subscribe(data => this.workbookList = data);
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
