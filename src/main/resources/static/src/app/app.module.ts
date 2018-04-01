import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {AuthService} from "./services/auth-service";
import { HomeComponent } from './home/home.component';
import {appRoutingProviders, routing} from "./app.routing";
import { AUTH_PROVIDERS } from 'angular2-jwt';
import {HomeService} from "./home/home.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {TokenInterceptor} from "./services/interceptor/token.interceptor";
import { WorkbookListComponent } from './components/workbook-list/workbook-list.component';
import { WorkbookComponent } from "./components/workbook/workbook.component";
import { ProfileComponent } from './components/profile/profile.component';
import { SearchComponent } from './components/search/search.component';
import {FormsModule} from "@angular/forms";
import {SearchService} from "./services/search/search.service";
import { ResultComponent } from './components/search/result/result.component';
import { CommentListComponent } from './components/comment-list/comment-list.component';
import { CommentComponent } from './components/comment/comment.component';
import {UserService} from "./services/user/user.service";
import {WorkbookService} from "./services/workbook/workbook.service";
import { AccordionModule } from 'ngx-bootstrap';
import { UserComponent } from './components/user/user.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    WorkbookListComponent,
    WorkbookComponent,
    ProfileComponent,
    SearchComponent,
    ResultComponent,
    CommentListComponent,
    CommentComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AccordionModule.forRoot(),
    routing
  ],
  providers: [appRoutingProviders,
    AUTH_PROVIDERS,
    AuthService,
    HomeService,
    SearchService,
    UserService,
    WorkbookService,
  {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
