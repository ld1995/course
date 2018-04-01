import { Injectable } from '@angular/core';
import {Workbook} from "../../models/workbook.model";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {User} from "../../models/user.model";

@Injectable()
export class UserService {

  private url = "user";

  constructor(private http: HttpClient) { }

  public getAllUsers() {
    this.http.get(`${environment.webServiceEndpoint}/private/${this.url}`)
      .subscribe(data => console.log(data));
  }

  public createUser() {
    this.http.get<User[]>(`${ environment.webServiceEndpoint}/private/${this.url}/add`)
      .subscribe(data => console.log(data))
  }

}
