import { Component, OnInit }   from '@angular/core';

import { Hero }                from './hero';
import { HeroService }         from './hero.service';

import 'rxjs/Rx';

@Component({
  selector: 'my-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: [ './heroes.component.css' ]
})

export class HeroesComponent implements OnInit {
  heroes: Hero[];

  constructor(private heroService: HeroService) { }

  getHeroes(): void {
      this.heroService.getHeroes()
          .subscribe(data => this.heroes = data);
  }

  ngOnInit(): void {
    this.getHeroes();
  }
}
