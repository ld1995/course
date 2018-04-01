import { TestBed, inject } from '@angular/core/testing';

import { WorkbookService } from './workbook.service';

describe('WorkbookService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [WorkbookService]
    });
  });

  it('should be created', inject([WorkbookService], (service: WorkbookService) => {
    expect(service).toBeTruthy();
  }));
});
