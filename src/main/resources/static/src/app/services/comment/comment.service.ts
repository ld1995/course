import {EventEmitter, Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../../environments/environment';
import {CommentModel} from '../../models/comment.model';
import {HttpClient} from '@angular/common/http';
import {LikeModel} from '../../models/like.model';
import {WorkbookModel} from '../../models/workbook.model';

@Injectable()
export class CommentService {

  constructor(private http: HttpClient) { }

  public getCommentById(id: number): Observable<CommentModel> {
    return this.http.get<CommentModel>(`${environment.webServiceEndpoint}/private/comment/${id}`);
  }

  public addComment(comment: CommentModel): Observable<CommentModel> {
    return this.http.post<CommentModel>(`${environment.webServiceEndpoint}/private/comment/`, comment);
  }
}
