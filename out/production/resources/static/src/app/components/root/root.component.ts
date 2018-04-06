import {Component, Inject, OnInit} from '@angular/core';
import {WorkbookService} from '../../services/workbook/workbook.service';
import {Workbook} from '../../models/workbook.model';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/takeUntil';

@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['./root.component.css']
})
export class RootComponent implements OnInit {

  public workbookList: Workbook[] = [];

  constructor(private workbookService: WorkbookService) {
  }

  ngOnInit() {
    this.workbookService.getWorkbookList().subscribe(data => this.workbookList = data);
    // Observable
    // // after 10s, tick every 5s
    //   .timer(10000, 5000)
    //   // stop this observable chain if stopTimer$ emits a value
    //   .takeUntil(stopTimer$)
    //   // select the model
    //   .map(_ => this.find(id))
    //   // do not go further unless the model has a property 'isActivated' truthy
    //   .filter(model => model['isActivated'])
    //   // only take one value so we don't need to manually unsubscribe
    //   .first()
    //   .subscribe();
  }

}
