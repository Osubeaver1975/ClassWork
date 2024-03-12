import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LearnerlistComponent } from './learnerlist.component';

describe('LearnerlistComponent', () => {
  let component: LearnerlistComponent;
  let fixture: ComponentFixture<LearnerlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LearnerlistComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LearnerlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
