import { Component } from '@angular/core';

const STUDENTS: Student[] = [
    {id: 999999, name: 'Bram'},
    {id: 111111, name: 'Stefan'}
];
@Component({
    selector : 'my-app',
    template : `<h1>{{title}}</h1>
    <ul>
        <li *ngFor="let student of students">
            <span>{{student.name}}</span>
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
}
