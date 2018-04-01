import {Component, OnInit} from '@angular/core';
import {Url} from "url";
import {AuthService} from "../../services/auth-service";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  private _nickname: string;
  private _picture: Url;
  //
  // constructor(private auth: AuthService) {
  //   this.nickname = this.auth.getProfile().nickname;
  //   this.picture = this.auth.getProfile().picture;
  // }
  constructor(public auth: AuthService) { }

  ngOnInit() {
    if (this.auth.userProfile) {
      // this.profile = this.auth.userProfile;
    } else {
      this.auth.getProfile((err, profile) => {
        const {nickname, picture} = profile;
        this._nickname = nickname;
        this._picture = picture;
      });
    }
  }


  get nickname(): string {
    return this._nickname;
  }

  set nickname(value: string) {
    this._nickname = value;
  }

  get picture(): Url {
    return this._picture;
  }

  set picture(value: Url) {
    this._picture = value;
  }
}

