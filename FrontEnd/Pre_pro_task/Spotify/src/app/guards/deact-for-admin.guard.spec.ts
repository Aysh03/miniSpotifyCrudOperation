import { TestBed } from '@angular/core/testing';

import { DeactForAdminGuard } from './deact-for-admin.guard';

describe('DeactForAdminGuard', () => {
  let guard: DeactForAdminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(DeactForAdminGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
