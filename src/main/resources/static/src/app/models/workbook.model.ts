
export class Workbook {
  id?: number;
  username: string;
  // private picture: URL;
  name: string;
  title: string;
  numberSpecialty: string;
  content: string;
  date?: Date;
  rating: number;
  questions: Array<number>;
  comments: Array<number>;
  tags: Array<string>;

  constructor(username: string, name: string, title: string, numberSpecialty: string, content: string) {
    this.username = username;
    this.name = name;
    this.title = title;
    this.numberSpecialty = numberSpecialty;
    this.content = content;
  }
}
