"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
  var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
  if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
  else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
  return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var STUDENTS = [
  { id: 999999, name: 'Bram' },
  { id: 111111, name: 'Stefan' }
];
var AppComponent = (function () {
  function AppComponent() {
    this.title = 'Students';
    this.students = STUDENTS;
  }
  return AppComponent;
}());
AppComponent = __decorate([
  core_1.Component({
    selector: 'my-app',
    template: "<h1>{{title}}</h1>\n    <ul>\n        <li *ngFor=\"let student of students\">\n            <span>{{student.name}}</span>\n        </li>\n    </ul>"
  })
], AppComponent);
exports.AppComponent = AppComponent;
var Student = (function () {
  function Student() {
  }
  return Student;
}());
exports.Student = Student;
//# sourceMappingURL=app.component.js.map
