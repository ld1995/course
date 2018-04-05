import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth0/auth-service';
import {Url} from 'url';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  public nickname: string;
  public picture: Url;

  constructor(public auth: AuthService) { }

  ngOnInit() {
    if (this.auth.userProfile) {
      this.initProfile(this.auth.userProfile);
    } else {
      this.auth.getProfile((err, profile) => {
        this.initProfile(profile);
      });
    }
  }
  private initProfile(profile) {
    const {nickname, picture} = profile;
    this.nickname = nickname;
    this.picture = picture;
  }
}

