/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CommitService } from './commit.service';

describe('CommitService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CommitService]
    });
  });

  it('should ...', inject([CommitService], (service: CommitService) => {
    expect(service).toBeTruthy();
  }));
});
