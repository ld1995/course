import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Workbook} from '../../models/workbook.model';
import {UserService} from '../../services/user/user.service';

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {
  @Input() dataSource: Workbook[];
  displayedColumns = ['Название', 'Номер специальности', 'Описание', 'Конспект'];
  constructor(private userService: UserService) { }

  ngOnInit() {
  }

}
