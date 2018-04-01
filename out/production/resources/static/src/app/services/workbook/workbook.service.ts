import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from '../../../environments/environment';
import {Workbook} from "../../models/workbook.model";
import * as Rx from "rxjs/Rx";
import {Observable} from "rxjs/Observable";
import {Tag} from "../../models/tag.model";

@Injectable()
export class WorkbookService {

  constructor(private http:HttpClient) {

  }
  private url = 'workbook';

  public getWorkbookList(): Observable<Workbook[]> {
    return this.http.get<Workbook[]>(`${environment.webServiceEndpoint}/public/${this.url}`)
  }


  //
  // getPerson(id: number): Rx.Observable<Person> {
  //   return this.http.get(`${webServiceEndpoint}/person/${id}`).map(this.extractData).publish().refCount();
  // }
  //
  // resolve(route: ActivatedRouteSnapshot,state: RouterStateSnapshot): Rx.Observable<Person> {
  //   return this.getPerson(Number(route.params['id']));
  // }
  //
  deleteWorkbook(id: number): Rx.Observable<Workbook> {
    return this.http.delete<Workbook>(`${environment.webServiceEndpoint}/private/${id}`);
  }

}
