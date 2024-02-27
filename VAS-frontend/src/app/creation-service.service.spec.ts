import { TestBed } from '@angular/core/testing';

import { CreationServiceService } from './creation-service.service';

describe('CreationServiceService', () => {
  let service: CreationServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreationServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
