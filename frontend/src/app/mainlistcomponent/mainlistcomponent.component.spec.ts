import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainlistcomponentComponent } from './mainlistcomponent.component';

describe('MainlistcomponentComponent', () => {
  let component: MainlistcomponentComponent;
  let fixture: ComponentFixture<MainlistcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainlistcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainlistcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
