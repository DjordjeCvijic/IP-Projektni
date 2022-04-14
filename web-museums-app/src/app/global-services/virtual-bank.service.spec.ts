import { TestBed } from '@angular/core/testing';

import { VirtualBankService } from './virtual-bank.service';

describe('VirtualBankService', () => {
  let service: VirtualBankService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VirtualBankService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
