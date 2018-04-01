import {Injectable, Input} from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {headersToString} from "selenium-webdriver/http";

@Injectable()
export class SearchService {
  constructor(private http: HttpClient) { }

  public search(query: string) {
    return this.http.post(`${ environment.webServiceEndpoint}/public/search`, query);
  }
}
