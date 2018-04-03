import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Workbook} from '../../models/workbook.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class WorkbookService {

  constructor(private http: HttpClient) {

  }

  public getWorkbookList(): Observable<Workbook[]> {
    return this.http.get<Workbook[]>(`${environment.webServiceEndpoint}/public/workbook`);
  }

  public getWorkbookById(id: number): Observable<Workbook> {
    return this.http.get<Workbook>(`${environment.webServiceEndpoint}/private/workbook/${id}`);
  }

  public deleteWorkbook(id: number): Observable<Workbook> {
    return this.http.delete<Workbook>(`${environment.webServiceEndpoint}/private/workbook/${id}`);
  }

  public createWorkbook(workbook: Workbook): Observable<Workbook> {
    return this.http.post<Workbook>(`${environment.webServiceEndpoint}/private/workbook`, workbook);
  }
}
