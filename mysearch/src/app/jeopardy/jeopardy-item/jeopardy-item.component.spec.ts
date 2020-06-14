import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JeopardyItemComponent } from './jeopardy-item.component';

describe('JeopardyItemComponent', () => {
  let component: JeopardyItemComponent;
  let fixture: ComponentFixture<JeopardyItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JeopardyItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JeopardyItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
