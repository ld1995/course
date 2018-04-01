import { Component } from '@angular/core';
import {AuthService} from "./services/auth-service";
import {SearchService} from "./services/search/search.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(public auth: AuthService, public search: SearchService) {
    auth.handleAuthentication();

  }
  title = 'Course';
}
