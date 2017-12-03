import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BooklistcomponentComponent } from './booklistcomponent.component';

describe('BooklistcomponentComponent', () => {
  let component: BooklistcomponentComponent;
  let fixture: ComponentFixture<BooklistcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BooklistcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BooklistcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
