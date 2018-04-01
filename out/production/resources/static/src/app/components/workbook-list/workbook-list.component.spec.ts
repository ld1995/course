import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkbookListComponent } from './workbook-list.component';

describe('WorkbookListComponent', () => {
  let component: WorkbookListComponent;
  let fixture: ComponentFixture<WorkbookListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkbookListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkbookListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
