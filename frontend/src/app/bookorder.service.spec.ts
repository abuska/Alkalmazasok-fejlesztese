import { TestBed, inject } from '@angular/core/testing';

import { BookorderService } from './bookorder.service';

describe('BookorderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BookorderService]
    });
  });

  it('should be created', inject([BookorderService], (service: BookorderService) => {
    expect(service).toBeTruthy();
  }));
});
