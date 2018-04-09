import {WorkbookModel} from './workbook.model';

export class UserModel {
  username: string;
  blocked: boolean;
  role: string;
  id?: number;
  workbookList: WorkbookModel[];

  constructor(username: string, blocked: boolean, role: string, id: number) {
    this.username = username;
    this.blocked = blocked;
    this.role = role;
    this.id = id;
  }
}
