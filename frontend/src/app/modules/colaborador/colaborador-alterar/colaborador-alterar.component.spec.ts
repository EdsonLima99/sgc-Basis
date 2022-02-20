import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ColaboradorAlterarComponent } from './colaborador-alterar.component';

describe('ColaboradorAlterarComponent', () => {
  let component: ColaboradorAlterarComponent;
  let fixture: ComponentFixture<ColaboradorAlterarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ColaboradorAlterarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ColaboradorAlterarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
