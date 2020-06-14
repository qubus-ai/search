import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { JeopardySearch } from './model/jeopardy-search';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { JeopardyDto } from './model/JeopardyDto';
import { Jeopardy } from './model/jeopardy';
import { JeopardyPaged } from './model/jeopardy-paged';

@Injectable({
  providedIn: 'root'
})
export class JeopardyService {

  private JEOPARDY_URL = 'http://localhost:9090/api/v1/jeopardy/';

  private SEARCH_URL = 'http://localhost:9090/api/v1/search/';

  constructor(private http: HttpClient) { }

  search(word: string): Observable<string[]> {
    return this.http.get<JeopardySearch>(this.SEARCH_URL + word).pipe(map(response => response.items))
  }

  getJeopardyPaged(word: string, page: number, size: number): Observable<JeopardyPaged> {
    let params = new HttpParams().set('page', page.toString()).set('size', size.toString());
    return this.http.get<JeopardyPaged>(this.JEOPARDY_URL + word, { params: params });
  }

}
