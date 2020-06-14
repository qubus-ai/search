import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {FormControl} from '@angular/forms';
import { JeopardyService } from '../jeopardy.service';
import {  MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-jeopardy-search',
  templateUrl: './jeopardy-search.component.html',
  styleUrls: ['./jeopardy-search.component.scss']
})
export class JeopardySearchComponent implements OnInit {

  inputControl = new FormControl();
  filteredOptions: string[];
  @Output() search: EventEmitter<string> = new EventEmitter();
  

  constructor(private jeopardyService: JeopardyService,
              private matSnackBar: MatSnackBar) {

  }

  ngOnInit() {
     this.inputControl.valueChanges.subscribe(async (value:string) => {
       if(value.length == 0) {
         this.filteredOptions = [];
         return;
       }
        this.jeopardyService.search(value).subscribe(items =>{
          this.filteredOptions = items;
        }, error => {
          this.filteredOptions = [];
          if(error.rstatus  != 404)
          {
            this.matSnackBar.open("Could not get autocomplete results" + error.status, "Error", {
              duration: 2000,
            });
          }
        })
     })
  }

  onOptionSelected(e: MatAutocompleteSelectedEvent) {
    this.onSearch();
  }

  onKeyDown(event) {
    if (event.key === "Enter") {
      this.onSearch();
    }
  }

  onSearch() {
    this.search.emit(this.inputControl.value);
  }
}
