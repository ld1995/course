import {Component, Input, OnInit} from '@angular/core';
import {RatingService} from '../../services/rating/rating.service';
import {Workbook} from '../../models/workbook.model';
import {RatingModel} from '../../models/rating.model';
import {AuthService} from '../../services/auth0/auth-service';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
  public mark: number;
  @Input() private workbook: Workbook;
  private ratingModel: RatingModel;

  constructor(private ratingService: RatingService, private auth: AuthService) { }

  ngOnInit() {
    this.mark = this.workbook.rating;
  }
  public onClickStar() {
    const {sub} = this.auth.userProfile;
    this.ratingModel = new RatingModel(sub, this.workbook.id, this.mark);
    this.ratingService.changeRating(this.ratingModel).subscribe(data => this.mark = data);
  }
}
