import { Component } from '@angular/core';
import {AuthService} from "./services/auth-service";
import {SearchService} from "./services/search/search.service";
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(public auth: AuthService, public route: Router) {
    auth.handleAuthentication();
  }
  public redirectToRoot() {
    this.navigate('');
  }
  public redirectToSettings() {
    this.navigate('settings');
  }
  public redirectToUser() {
    this.navigate('user');
  }
  private navigate(url: string) {
    this.route.navigateByUrl(url);
  }

}
