///<reference path="../../../node_modules/@angular/core/src/metadata/directives.d.ts"/>
import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  @Input() user: User;
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
  ) {}

  ngOnInit() {
  }
  save(): void {
    this.userService.updateUser(this.user);
  }
}
