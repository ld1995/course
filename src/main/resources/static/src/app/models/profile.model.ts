export class Profile {
  private _nickname: string;
  private _picture: URL;

  constructor(nickname: string,picture: URL) {
    this._nickname = nickname;
    this._picture = picture;
  }

  get nickname(): string {
    return this._nickname;
  }

  set nickname(value: string) {
    this._nickname = value;
  }

  get picture(): URL {
    return this._picture;
  }

  set picture(value: URL) {
    this._picture = value;
  }
}
