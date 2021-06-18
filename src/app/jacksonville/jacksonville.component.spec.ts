import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JacksonvilleComponent } from './jacksonville.component';

describe('JacksonvilleComponent', () => {
  let component: JacksonvilleComponent;
  let fixture: ComponentFixture<JacksonvilleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JacksonvilleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JacksonvilleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
