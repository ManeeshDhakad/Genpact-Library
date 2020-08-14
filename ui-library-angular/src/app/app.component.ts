import { Component, OnInit} from '@angular/core';
declare var $:any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ui-library-angular';
  public collapseNabBar : boolean;
  public colClassName1 : string;
  public colClassName2 : string;

  constructor() {
  }

  ngOnInit(): void {
    this.collapseNabBar = false;
    this.colClassName1 = 'col-lg-2 col-md-3 col-sm-4 col-xs-4';
    this.colClassName2 = 'col-lg-10 col-md-9 col-sm-8 col-xs-8';
    $('[data-toggle="tooltip"]').tooltip();
  }

  changeCollapseNabBar() {
    if(this.collapseNabBar) {
        this.collapseNabBar = false;
        this.colClassName1 = 'col-lg-2 col-md-3 col-sm-4 col-xs-4';
        this.colClassName2 = 'col-lg-10 col-md-9 col-sm-8 col-xs-8';
        
    } else {
        this.collapseNabBar = true;
        this.colClassName1 = 'col-lg-1 col-md-2 col-sm-2 col-xs-2';
        this.colClassName2 = 'col-lg-11 col-md-10 col-sm-10 col-xs-10';
    }
  }
  
}
