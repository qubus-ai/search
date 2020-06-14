import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JeopardySearchComponent } from './jeopardy-search/jeopardy-search.component';
import { MaterialModule } from '../material-module';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { JeopardyComponent } from './jeopardy/jeopardy.component';
import { JeopardyListComponent } from './jeopardy-list/jeopardy-list.component';
import { JeopardyItemComponent } from './jeopardy-item/jeopardy-item.component';

@NgModule({
  declarations: [JeopardySearchComponent, JeopardyComponent, JeopardyListComponent, JeopardyItemComponent],
  imports: [
    CommonModule,
    MaterialModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [
    JeopardySearchComponent,
    JeopardyComponent,
    JeopardyListComponent,
    JeopardyItemComponent
  ]
})
export class JeopardyModule { }
