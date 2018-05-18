import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';


// Class participates in dependency injection system
@Injectable({
  /* can deliver the service */
  providedIn: 'root'
})
export class UserService {

  constructor(private messageService: MessageService) { }


  getUsers(): Observable<User[]> {
    this.messageService.add('Userservice: fetched users');
    return of([{firstname: 'Bram',
        lastname: 'Slegers',
        email: 'bram@ucll.be'},
      {
        firstname: 'Maarten',
        lastname: 'Slegers',
        email: 'maarten@ucll.be'
      }
    ]);
  }
}
