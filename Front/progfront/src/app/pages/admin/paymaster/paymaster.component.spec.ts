import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymasterComponent } from './paymaster.component';

describe('PaymasterComponent', () => {
  let component: PaymasterComponent;
  let fixture: ComponentFixture<PaymasterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymasterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymasterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
