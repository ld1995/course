import {Component, Input, OnInit} from '@angular/core';
import {RatingService} from '../../services/rating/rating.service';
import {WorkbookModel} from '../../models/workbook.model';
import {RatingModel} from '../../models/rating.model';
import {AuthService} from '../../services/auth0/auth-service';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
  public mark: number;
  @Input() private workbook: WorkbookModel;
  private ratingModel: RatingModel;

  constructor(private ratingService: RatingService, private auth: AuthService) { }

  public onClickStar() {
    this.ratingModel = new RatingModel(this.auth.userProfile.sub, this.workbook.id, this.mark);
    this.ratingService.changeRating(this.ratingModel).subscribe(data => {
      this.workbook.rating = data;
      this.ngOnInit();
    } );
  }

  ngOnInit(): void {
    this.mark = this.workbook.rating;
  }
}
