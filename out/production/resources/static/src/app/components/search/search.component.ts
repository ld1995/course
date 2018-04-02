import {Component, Input, OnInit} from '@angular/core';
import {SearchService} from "../../services/search/search.service";
import {Router} from "@angular/router";
import {Workbook} from "../../models/workbook.model";
import {SearchDataService} from "../../services/search/search-data.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  ngOnInit(): void {
  }

  @Input() query: string;
  constructor(private searchService: SearchService) {
  }

  public search(query: string) {
    this.searchService.search(query).subscribe( data => this.redirect(data));
    //https://angular.io/guide/form-validation
    this.query = '';
  }

  private redirect(data = []) {
    console.log(data);
    this.searchService.data = data;
    this.route.navigate(['result']);
  }
}
