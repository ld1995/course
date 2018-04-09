import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {UserModel} from '../../models/user.model';

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  public getAllUsers() {
    this.http.get(`${environment.webServiceEndpoint}/private/user`)
      .subscribe(data => console.log(data));
  }

  public addUser() {
    this.http.get<UserModel[]>(`${ environment.webServiceEndpoint}/private/user/add`)
      .subscribe(data => console.log(data));
  }
}
