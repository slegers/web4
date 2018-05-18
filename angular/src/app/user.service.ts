import { Injectable } from '@angular/core';
import { User } from './user';

// Class participates in dependency injection system
@Injectable({
  /* can deliver the service */
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  getHeroes(): User[] {
    return [
      {firstname: 'Bram',
        lastname: 'Slegers',
        email: 'bram@ucll.be'},
      {
        firstname: 'Maarten',
        lastname: 'Slegers',
        email: 'maarten@ucll.be'
      }
    ];
  }
}
