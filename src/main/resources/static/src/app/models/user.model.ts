export class User {
  username: string;
  blocked: boolean;
  role: string;
  id?: number;

  constructor(username: string, blocked: boolean, role: string, id: number) {
    this.username = username;
    this.blocked = blocked;
    this.role = role;
    this.id = id;
  }
}
