import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JeopardyRoutingModule } from './jeopardy/jeopardy-routing.module';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'jeopardy',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    JeopardyRoutingModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
