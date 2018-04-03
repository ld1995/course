export class RatingModel {
  author: string;
  workbookId: number;
  mark: number;

  constructor(author: string, workbookId: number, mark: number) {
    this.author = author;
    this.workbookId = workbookId;
    this.mark = mark;
  }
}
