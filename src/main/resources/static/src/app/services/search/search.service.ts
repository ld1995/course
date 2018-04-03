import {Injectable, Input} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Workbook} from '../../models/workbook.model';

@Injectable()
export class SearchService {
  constructor(private http: HttpClient) { }

  public data: Workbook[] = [];

  public search(query: string) {
    return this.http.post<Workbook[]>(`${ environment.webServiceEndpoint}/public/search`, query);
  }
}
