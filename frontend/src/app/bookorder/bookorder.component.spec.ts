import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookorderComponent } from './bookorder.component';

describe('BookorderComponent', () => {
  let component: BookorderComponent;
  let fixture: ComponentFixture<BookorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
