///<reference path="home.service.ts"/>
import { Component, OnInit } from '@angular/core';
import {HomeService} from "./home.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [HomeService]
})
export class HomeComponent {

  constructor(public homeService: HomeService) {

  }

  public getPublicData() {
    this.homeService.getPublic()
      .subscribe(data => {
        console.log(data);
      });
  }

  public getPrivateData() {
    this.homeService.securedPing();
  }

}
