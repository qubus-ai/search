import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { JeopardyComponent } from './jeopardy/jeopardy.component';


const routes: Routes = [
  {
    path: 'jeopardy',
    component: JeopardyComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class JeopardyRoutingModule { }