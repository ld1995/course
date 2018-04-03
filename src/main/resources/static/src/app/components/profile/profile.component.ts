import {Component, OnInit} from '@angular/core';
import {Url} from 'url';
import {AuthService} from '../../services/auth0/auth-service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  private _nickname: string;
  private _picture: Url;

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

