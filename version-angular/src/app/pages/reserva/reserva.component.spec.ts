import { ComponentFixture, TestBed } from '@angular/core/testing';
//import { DateRange } from '@angular/material/datepicker';//
import { ReservaComponent } from './reserva.component';


describe('ReservaComponent', () => {
  let component: ReservaComponent;
  let fixture: ComponentFixture<ReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
