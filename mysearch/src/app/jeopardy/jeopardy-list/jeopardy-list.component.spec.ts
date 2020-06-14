import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JeopardyListComponent } from './jeopardy-list.component';

describe('JeopardyListComponent', () => {
  let component: JeopardyListComponent;
  let fixture: ComponentFixture<JeopardyListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JeopardyListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JeopardyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
