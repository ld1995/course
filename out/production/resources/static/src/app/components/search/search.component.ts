import {Component, Input} from '@angular/core';
import {SearchService} from "../../services/search/search.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  @Input() query: string;
  constructor(private searchService: SearchService, private route: Router) {
  }

  public search(query: string) {
    this.searchService.search(query).subscribe( data => {
      data !== [] ? this.route.navigate(['result']) : this.showWindow(data)});
    //https://angular.io/guide/form-validation
    this.query = '';
  }

  public showWindow(data) {
    console.log(data)
  }
}
