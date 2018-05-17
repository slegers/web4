import { Component } from '@angular/core';
import {User} from './user';
/** This is a description of the foo function. */
const Users: User[] = [
   {id: 999999, firstName: 'Bram', lastName: 'Sl', email: 'bram@ucll.be' },
  {id: 111111, firstName: 'Stefan', lastName: 'vl', email: 'stefan@ucll.be' }
];
@Component({
  selector : 'app-user',
  template : `<h1>{{title}}</h1>
  <ul>
    <li *ngFor="let user of users">
      <ul>
        <li>{{user.firstName}}</li>
        <li>{{user.lastName}}</li>
        <li>{{user.email}}</li>
        <li>{{user.id}}</li>
      </ul>
    </li>
  </ul>`
})
export class AppComponent {
  title = 'Users';
  users = Users;
}

