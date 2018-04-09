import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {WorkbookModel} from '../../models/workbook.model';
import {HttpClient} from '@angular/common/http';
import {RatingModel} from '../../models/rating.model';

@Injectable()
export class RatingService {
  private url = `${ environment.webServiceEndpoint}/private/workbook/rating`;
  constructor(private http: HttpClient) { }

  public changeRating(ratingModel: RatingModel) {
    return this.http.post<number>(this.url, ratingModel);
  }
}
