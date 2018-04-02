import {Injectable} from "@angular/core";
import {Workbook} from "../../models/workbook.model";


@Injectable()
export class SearchDataService {

  constructor(data: Workbook[]) {
    this._data = data;
  }

  private _data: Workbook[];

  get data(): Workbook[] {
    return this._data;
  }

  set data(value: Workbook[]) {
    this._data = value;
  }
}
