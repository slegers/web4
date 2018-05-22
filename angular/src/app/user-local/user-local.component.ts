import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import {User} from '../user';

@Component({
  selector: 'app-user-local',
  templateUrl: './user-local.component.html',
  styleUrls: ['./user-local.component.css']
})
export class UserLocalComponent implements OnInit {
  usersLocal: User[];
  selectedLocalUer: User;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getLocalUsers();
  }
  onSelect(u: User): void {
    this.selectedLocalUer = u;
  }

  getLocalUsers(): void {
    this.userService.getLocalUsers().subscribe((data) => this.usersLocal = data);
  }
}
