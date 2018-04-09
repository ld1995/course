import {TagModel} from './tag.model';
import {QuestionModel} from './question.model';
import {CommentModel} from './comment.model';

export class WorkbookModel {
  id?: number;
  username: string;
  // private picture: URL;
  name: string;
  title: string;
  numberSpecialty: string;
  content: string;
  date?: Date;
  rating: number;
  questions: QuestionModel[];
  comments: CommentModel[];
  tags: TagModel[];
}
