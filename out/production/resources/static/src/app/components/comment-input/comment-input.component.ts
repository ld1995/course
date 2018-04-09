import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CommentModel} from '../../models/comment.model';
import {CommentService} from '../../services/comment/comment.service';
import {WorkbookModel} from '../../models/workbook.model';
import {AuthService} from '../../services/auth0/auth-service';

@Component({
  selector: 'app-comment-input',
  templateUrl: './comment-input.component.html',
  styleUrls: ['./comment-input.component.css']
})
export class CommentInputComponent implements OnInit {

  @Input() commentId: number;
  @Input() workbookId: number;
  newComment: CommentModel;
  @Output() onUpdate: EventEmitter<CommentModel> = new EventEmitter();

  public content: string;

  constructor(private commentService: CommentService, private auth: AuthService) { }

  ngOnInit() {
  }

  public addComment(content: string) {
    this.newComment = new CommentModel(this.auth.userProfile.sub, this.workbookId, content);
    if (this.commentId) {
      this.newComment.parentId = this.commentId;
    }
    this.commentService.addComment(this.newComment).subscribe( data => this.onUpdate.emit(data));
  }
}
