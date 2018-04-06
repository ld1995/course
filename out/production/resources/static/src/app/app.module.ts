import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {AuthService} from './services/auth0/auth-service';
import { HomeComponent } from './home/home.component';
import {appRoutingProviders, routing} from './app.routing';
import { AUTH_PROVIDERS } from 'angular2-jwt';
import {HomeService} from './home/home.service';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {TokenInterceptor} from './services/interceptor/token.interceptor';
import { WorkbookListComponent } from './components/workbook-list/workbook-list.component';
import { WorkbookComponent } from './components/workbook/workbook.component';
import { ProfileComponent } from './components/profile/profile.component';
import { SearchComponent } from './components/search/search.component';
import {FormsModule} from '@angular/forms';
import {SearchService} from './services/search/search.service';
import { ResultComponent } from './components/search/result/result.component';
import { CommentListComponent } from './components/comment-list/comment-list.component';
import { CommentComponent } from './components/comment/comment.component';
import {UserService} from './services/user/user.service';
import {WorkbookService} from './services/workbook/workbook.service';
import { AccordionModule } from 'ngx-bootstrap';
import { UserComponent } from './components/user/user.component';
import { RootComponent } from './components/root/root.component';
import { SettingsComponent } from './components/settings/settings.component';
import {MarkdownModule, MarkedOptions} from 'ngx-markdown';
import { RatingComponent } from './components/rating/rating.component';
import {BarRatingModule} from 'ngx-bar-rating';
import {RatingService} from './services/rating/rating.service';
import {AuthGuardService} from './services/auth0/AuthGuardService';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { UserTableComponent } from './components/user-table/user-table.component';
import { FileDropDirective } from './directive/file-drop/file-drop.directive';
import {AngularFireModule} from 'angularfire2';
import {environment} from '../environments/environment';
import {AngularFireDatabaseModule} from 'angularfire2/database';
import {Ng2ImgToolsModule} from 'ng2-img-tools';

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
    UserComponent,
    RootComponent,
    SettingsComponent,
    RatingComponent,
    UserTableComponent,
    FileDropDirective
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AccordionModule.forRoot(),
    routing,
    MarkdownModule.forRoot({
      provide: MarkedOptions,
      useValue: {
        gfm: true,
        tables: true,
        breaks: false,
        pedantic: false,
        sanitize: false,
        smartLists: true,
        smartypants: false,
      },
    }),
    BarRatingModule,
    BrowserAnimationsModule,
    AngularFireModule.initializeApp(environment.configFirebase),
    AngularFireDatabaseModule,
    Ng2ImgToolsModule
  ],
  providers: [appRoutingProviders,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    AUTH_PROVIDERS,
    AuthService,
    HomeService,
    SearchService,
    UserService,
    WorkbookService,
    ResultComponent,
    RatingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
