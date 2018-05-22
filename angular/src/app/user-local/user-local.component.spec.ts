import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLocalComponent } from './user-local.component';

describe('UserLocalComponent', () => {
  let component: UserLocalComponent;
  let fixture: ComponentFixture<UserLocalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserLocalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserLocalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
