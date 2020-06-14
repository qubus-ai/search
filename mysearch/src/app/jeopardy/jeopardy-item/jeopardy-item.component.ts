import { Component, OnInit, Input } from '@angular/core';
import { Jeopardy } from '../model/jeopardy';

@Component({
  selector: 'app-jeopardy-item',
  templateUrl: './jeopardy-item.component.html',
  styleUrls: ['./jeopardy-item.component.scss']
})
export class JeopardyItemComponent implements OnInit {

  @Input() jeopardy: Jeopardy;

  constructor() { }

  ngOnInit(): void {
  }

}