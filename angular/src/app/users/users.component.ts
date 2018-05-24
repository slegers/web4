import { Component, OnInit } from '@angular/core';
import {User} from '../user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from '../user.service';
import {interval, Observable, timer} from 'rxjs';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {
  selectedUser: User;
  users: User[];
  /* Crreates singelton of service (uses DI) */
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUsers();
  }


  onSelect(u: User): void {
    this.selectedUser = u;
  }

  getUsers(): void {
   const n = interval(1000);
      n.subscribe(() => {
        this.userService.getUsers().subscribe((data) => this.users = data);
      });
  }

}
