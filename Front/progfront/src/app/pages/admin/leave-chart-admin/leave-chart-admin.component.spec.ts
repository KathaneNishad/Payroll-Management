import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveChartAdminComponent } from './leave-chart-admin.component';

describe('LeaveChartAdminComponent', () => {
  let component: LeaveChartAdminComponent;
  let fixture: ComponentFixture<LeaveChartAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaveChartAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveChartAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
