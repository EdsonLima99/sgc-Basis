/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CompetenciaService } from './competencia.service';

describe('Service: Competencia', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CompetenciaService]
    });
  });

  it('should ...', inject([CompetenciaService], (service: CompetenciaService) => {
    expect(service).toBeTruthy();
  }));
});
