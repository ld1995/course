export class User {
  private _username: string;
  private _blocked: boolean;
  private _role: string;
  private id?: number;

  constructor(username: string, blocked: boolean, role: string, id: number) {
    this._username = username;
    this._blocked = blocked;
    this._role = role;
    this.id = id;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get blocked(): boolean {
    return this._blocked;
  }

  set blocked(value: boolean) {
    this._blocked = value;
  }

  get role(): string {
    return this._role;
  }

  set role(value: string) {
    this._role = value;
  }
}
