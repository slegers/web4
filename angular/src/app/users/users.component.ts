import { Component, OnInit } from '@angular/core';
import {User} from '../user';

const user: User[] = [
  {firstname: 'Bram',
    lastname: 'Slegers',
    email: 'bram@ucll.be'},
  {
    firstname: 'Maarten',
    lastname: 'Slegers',
    email: 'maarten@ucll.be'
  }
];

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {
  selectedUser: User;

  users: User[] = user;
  constructor() { }

  ngOnInit() {
  }


  onSelect(u: User): void {
    this.selectedUser = u;
  }
}
