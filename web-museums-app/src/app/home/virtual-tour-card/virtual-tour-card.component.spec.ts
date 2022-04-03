import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VirtualTourCardComponent } from './virtual-tour-card.component';

describe('VirtualTourCardComponent', () => {
  let component: VirtualTourCardComponent;
  let fixture: ComponentFixture<VirtualTourCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VirtualTourCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VirtualTourCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
