import { TestBed } from '@angular/core/testing';

import { SelecionaService } from './seleciona.service';

describe('SelecionaService', () => {
  let service: SelecionaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SelecionaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
