import { NgModule }         from '@angular/core';
import { BrowserModule }    from '@angular/platform-browser';
import { HttpModule }       from '@angular/http';
import { FormsModule }      from '@angular/forms';

import { AppComponent }     from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HeroesComponent }  from './heroes.component';
import { HeroService }      from './hero.service';

@NgModule({
  imports: [
    BrowserModule,
      FormsModule,
      AppRoutingModule,
      HttpModule
  ],
  declarations: [
    AppComponent,
      HeroesComponent
  ],
  providers: [ HeroService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
