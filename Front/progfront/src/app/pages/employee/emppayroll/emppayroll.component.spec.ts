import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmppayrollComponent } from './emppayroll.component';

describe('EmppayrollComponent', () => {
  let component: EmppayrollComponent;
  let fixture: ComponentFixture<EmppayrollComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmppayrollComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmppayrollComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
