import { TestBed } from '@angular/core/testing';

import { UsersInfoService } from './users-Info.service';

describe('LoginHistoryService', () => {
  let service: UsersInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsersInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
