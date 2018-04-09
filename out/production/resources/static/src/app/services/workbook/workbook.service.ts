import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {WorkbookModel} from '../../models/workbook.model';
import {Observable} from 'rxjs/Observable';
import {CommentModel} from '../../models/comment.model';

@Injectable()
export class WorkbookService {

  constructor(private http: HttpClient) {
  }

  public getWorkbookList(): Observable<WorkbookModel[]> {
    return this.http.get<WorkbookModel[]>(`${environment.webServiceEndpoint}/public/workbook`);
  }

  public getWorkbookById(id: number): Observable<WorkbookModel> {
    return this.http.get<WorkbookModel>(`${environment.webServiceEndpoint}/private/workbook/${id}`);
  }

  public deleteWorkbook(id: number): Observable<WorkbookModel> {
    return this.http.delete<WorkbookModel>(`${environment.webServiceEndpoint}/private/workbook/${id}`);
  }

  public addWorkbook(workbook: WorkbookModel): Observable<WorkbookModel> {
    return this.http.post<WorkbookModel>(`${environment.webServiceEndpoint}/private/workbook`, workbook);
  }

  public getWorkbookListByUsername(username: String): Observable<WorkbookModel[]> {
    return this.http.post<WorkbookModel[]>(`${environment.webServiceEndpoint}/private/workbook/user`, username);
  }

  public updateWorkbook(workbook: WorkbookModel): Observable<WorkbookModel> {
    return this.http.put<WorkbookModel>(`${environment.webServiceEndpoint}/private/workbook`, workbook);
  }

  public getCommentListByWorkbookId(id: number): Observable<CommentModel[]> {
    return this.http.get<CommentModel[]>(`${environment.webServiceEndpoint}/private/workbook/${id}/comments`);
  }
}
