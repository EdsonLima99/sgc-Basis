import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TurmaFormacaoFormComponent } from './turma-formacao-form.component';

describe('TurmaFormacaoFormComponent', () => {
  let component: TurmaFormacaoFormComponent;
  let fixture: ComponentFixture<TurmaFormacaoFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TurmaFormacaoFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TurmaFormacaoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
