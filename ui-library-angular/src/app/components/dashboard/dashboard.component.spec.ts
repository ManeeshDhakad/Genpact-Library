import { async, ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';

import { DashboardComponent } from './dashboard.component';
import { LibService } from 'src/app/services/lib.service';
import { promise } from 'protractor';
import { LibModel } from 'src/app/models/lib-model';

const libs  = [
  {
    id : 1,
    name : 'Lib1',
    description : 'Lib1 Desc'
  },
  {
    id : 2,
    name : 'Lib2',
    description : 'Lib2 Desc'
  }
];

const books = [
  {
    id : 1,
    name : 'Book1',
    description : 'Book1 Desc'
  },
  {
    id : 2,
    name : 'Book2',
    description : 'Book2 Desc'
  }
]

describe('DashboardComponent', () => {
  let component: DashboardComponent;
  let fixture: ComponentFixture<DashboardComponent>;
  let libService : LibService;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardComponent ],
      providers : [LibService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardComponent);
    component = fixture.componentInstance;
    libService = TestBed.get(LibService);
    fixture.detectChanges();

    libService.getAllLibs = jasmine.createSpy().and.returnValue(Promise.resolve(libs));
    libService.getAllBooks = jasmine.createSpy().and.returnValue(Promise.resolve(books));
  });

  it('Load libraries', fakeAsync(() => {
    component.loadAllLibs();
    fixture.detectChanges();
    tick();
    expect(component.libs.length).toBe(libs.length);
  }));

  it('Load books', fakeAsync(() => {
    let lib : LibModel = libs[0];
    component.loadBooks(lib)
    fixture.detectChanges();
    tick();
    expect(lib.books.length).toBe(books.length);
  }));
});