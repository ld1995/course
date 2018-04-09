import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {environment} from '../../../environments/environment';
import {TagModel} from '../../models/tag.model';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class TagService {

  constructor(private http: HttpClient) { }

  public getWorkbookList(): Observable<TagModel[]> {
    return this.http.get<TagModel[]>(`${environment.webServiceEndpoint}/public/tag`);
  }

}
