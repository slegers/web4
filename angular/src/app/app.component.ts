import { Component } from '@angular/core';

const STUDENTS: Student[] = [
  {id: 999999, name: 'Bram', email: 'bram@ucll.be'},
  {id: 111111, name: 'Stefan', email: 'bram@ucll.be'}
];
@Component({
  selector : 'my-app',
  template : `<h1>{{title}}</h1>
            <ul>
              <li *ngFor="let student of students">
                <span>{{student.name}}</span>
                <span>{{ student.id}}</span>
                <span>{{ student.email}}</span>

              </li>
            </ul>`
})
export class AppComponent {
  title = 'Students';
  students = STUDENTS;
}
export class Student {
  id: number;
  name: string;
  email: string;
}
