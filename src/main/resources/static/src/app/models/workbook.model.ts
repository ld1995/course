import {Tag} from "./tag.model";

export class Workbook {
  private _username: string;
  // private picture: URL;
  private _name: string;
  private _title: string;
  private _numberSpecialty: string;
  private _content: string;
  private _date: Date;
  private _rating: number;
  private _questions: Array<number>;
  private _comments: Array<number>;
  private _tags: Array<string>;

  constructor(username: string, name: string, title: string,
              numberSpecialty: string, content: string, date: Date,
              rating: number, questions: Array<number>,
              comments: Array<number>, tags: Array<string>) {
    this._username = username;
    this._name = name;
    this._title = title;
    this._numberSpecialty = numberSpecialty;
    this._content = content;
    this._date = date;
    this._rating = rating;
    this._questions = questions;
    this._comments = comments;
    this._tags = tags;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get numberSpecialty(): string {
    return this._numberSpecialty;
  }

  set numberSpecialty(value: string) {
    this._numberSpecialty = value;
  }

  get content(): string {
    return this._content;
  }

  set content(value: string) {
    this._content = value;
  }

  get date(): Date {
    return this._date;
  }

  set date(value: Date) {
    this._date = value;
  }

  get rating(): number {
    return this._rating;
  }

  set rating(value: number) {
    this._rating = value;
  }

  get questions(): Array<number> {
    return this._questions;
  }

  set questions(value: Array<number>) {
    this._questions = value;
  }

  get comments(): Array<number> {
    return this._comments;
  }

  set comments(value: Array<number>) {
    this._comments = value;
  }

  get tags(): Array<string> {
    return this._tags;
  }

  set tags(value: Array<string>) {
    this._tags = value;
  }
}
