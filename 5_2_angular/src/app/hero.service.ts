import { Injectable }     from '@angular/core';
import { Http }           from '@angular/http';

import { Hero }  from './hero';

import 'rxjs/Rx';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class HeroService {

  private heroesUrl = 'http://localhost:8080/Heroes/Controller';

  constructor(private http: Http) {
  }

  getHeroes(): Observable<Hero[]> {
      return Observable
      .interval(5000)
      .flatMap(() => this.http.get(this.heroesUrl).map((data) => data.json()));
  }
}

