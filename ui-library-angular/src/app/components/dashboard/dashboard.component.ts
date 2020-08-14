import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';
import { LibService} from 'src/app/services/lib.service';
import { BookModel } from 'src/app/models/book-model';
import { LibModel } from 'src/app/models/lib-model';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit, OnDestroy {
  public libs : LibModel[] = [];
 
  constructor(
    private router: Router, 
    private libService : LibService,
    private changeDetectorRef : ChangeDetectorRef) {          
  }

  ngOnDestroy(): void {
  }

  async ngOnInit() {
    await this.loadAllLibs();
    this.changeDetectorRef.detectChanges();
  }

  async loadAllLibs() : Promise<any> {
    this.libs = await this.libService.getAllLibs();
    return Promise.resolve(true);
  }

  async loadBooks(lib : LibModel) : Promise<any> {
    lib.books = [...await this.libService.getAllBooks(lib.id)]
    this.changeDetectorRef.detectChanges();
    return Promise.resolve(true);
  }
}
