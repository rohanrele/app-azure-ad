import { TestBed } from '@angular/core/testing';

import { MessageFromBackendService } from './message-from-backend.service';

describe('MessageFromBackendService', () => {
  let service: MessageFromBackendService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MessageFromBackendService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
