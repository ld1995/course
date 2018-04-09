import {LikeModel} from './like.model';
import {WorkbookModel} from './workbook.model';
import {UserModel} from './user.model';

export class CommentModel {
  id?: number;
  username: string;
  workbookId?: number;
  date: Date;
  content: string;
  like: LikeModel;
  comments?: CommentModel[];
  parentId?: number;


  constructor(username: string, workbookId: number, content: string) {
    this.username = username;
    this.workbookId = workbookId;
    this.content = content;
  }
}
