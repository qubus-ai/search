import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { JeopardyService } from '../jeopardy.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Jeopardy } from '../model/jeopardy';
import { MatPaginator, PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-jeopardy-list',
  templateUrl: './jeopardy-list.component.html',
  styleUrls: ['./jeopardy-list.component.scss']
})
export class JeopardyListComponent implements OnInit  {

  private paginator: MatPaginator;
  @ViewChild('paginator', { static: false }) set paginatorChild(content: MatPaginator) {
    if(content) {
      this.paginator = content;
    }
  }

  paginatorPageSize = 10;

  jeopardies: Jeopardy[];

  currentWord: string;
  totalElements: number;

  constructor(private jeopardyService: JeopardyService,
              private matSnackBar: MatSnackBar) { }

  ngOnInit(): void {

  }

  
  onPageChanged(pageEvent: PageEvent ) {
    this.fillList(this.currentWord);
  }

  fillList(word: string) {
    this.currentWord = word;
    let page = 0;
    let size = this.paginatorPageSize;
    if(this.paginator) {
      page = this.paginator.pageIndex;
      size = this.paginator.pageSize;
    }

    this.jeopardyService.getJeopardyPaged(word, page, size)
            .subscribe(response => {
              this.jeopardies = response.content;
              this.totalElements = response.totalElements;
            },
               error => {
                 this.jeopardies = [];
                  this.matSnackBar.open("Could not get search results", "Error", {
                    duration: 2000,
                  });
            });
  }


  
}
