import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClintListComponent } from './clint-list.component';

describe('ClintListComponent', () => {
  let component: ClintListComponent;
  let fixture: ComponentFixture<ClintListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClintListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ClintListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
