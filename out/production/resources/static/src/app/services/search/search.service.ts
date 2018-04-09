import {Injectable, Input} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {WorkbookModel} from '../../models/workbook.model';

@Injectable()
export class SearchService {
  constructor(private http: HttpClient) { }

  public data: WorkbookModel[] = [];

  public search(query: string) {
    return this.http.post<WorkbookModel[]>(`${ environment.webServiceEndpoint}/public/search`, query);
  }
}
