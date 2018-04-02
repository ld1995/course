import {Component, Input, OnInit} from '@angular/core';
import {SearchService} from "../../services/search/search.service";
import {Router} from "@angular/router";
import {Workbook} from "../../models/workbook.model";
import {ResultComponent} from "./result/result.component";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  ngOnInit(): void {
  }

  @Input() query: string;
  constructor(private searchService: SearchService, private route: Router, private result: ResultComponent) {
  }

  public search(query: string) {
    this.searchService.search(query).subscribe( data => this.redirect(data));
    //https://angular.io/guide/form-validation
    this.query = '';
  }

  public redirect(data) {
    this.searchService.data = data;
     if(this.route.navigateByUrl('result')) {
       this.result.ngOnInit();
     }
  }
}
