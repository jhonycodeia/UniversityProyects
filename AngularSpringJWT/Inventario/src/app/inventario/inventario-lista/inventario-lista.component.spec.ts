import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventarioListaComponent } from './inventario-lista.component';

describe('InventarioListaComponent', () => {
  let component: InventarioListaComponent;
  let fixture: ComponentFixture<InventarioListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventarioListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventarioListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
