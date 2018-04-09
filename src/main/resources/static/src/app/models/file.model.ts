export class FileModel {
  $key: string;
  file: File;
  name: string;
  url: string;
  createdAt: Date = new Date();
  progress: number;
  constructor(file: File) {
    this.file = file;
  }
}
