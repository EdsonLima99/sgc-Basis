import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TurmaFormacaoListaComponent } from './turma-formacao-lista.component';

describe('TurmaFormacaoListaComponent', () => {
  let component: TurmaFormacaoListaComponent;
  let fixture: ComponentFixture<TurmaFormacaoListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TurmaFormacaoListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TurmaFormacaoListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
