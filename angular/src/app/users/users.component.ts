import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {
  selectedUser: User;

  users: User[];
  /* Crreates singelton of service */
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
  }


  onSelect(u: User): void {
    this.selectedUser = u;
  }
  getUsers(): void {
    /* subscribe makes the async funtion possible */
    this.userService.getUsers()
      .subscribe(users => this.users = users);
  }
}
