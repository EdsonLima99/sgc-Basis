import { TestBed } from '@angular/core/testing';

import { TurmaFormacaoService } from './turma-formacao.service';

describe('TurmaFormacaoService', () => {
  let service: TurmaFormacaoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TurmaFormacaoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
