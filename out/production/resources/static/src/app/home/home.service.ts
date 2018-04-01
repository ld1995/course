import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
 import {environment} from '../../environments/environment'

@Injectable()
export class HomeService {

  constructor(private http:HttpClient) {}

  public getPublic() {
    return this.http.get(`${ environment.webServiceEndpoint}/public/get`);
  }

  public securedPing(): void {
    this.http
      .get(`${environment.webServiceEndpoint}/private/get`)
      .subscribe(
        data => console.log(data),
        error => console.log(error)
      );
  }
}
