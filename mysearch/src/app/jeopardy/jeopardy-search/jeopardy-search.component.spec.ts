import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JeopardySearchComponent } from './jeopardy-search.component';

describe('JeopardySearchComponent', () => {
  let component: JeopardySearchComponent;
  let fixture: ComponentFixture<JeopardySearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JeopardySearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JeopardySearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
