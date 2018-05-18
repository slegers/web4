import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

// Class participates in dependency injection system
@Injectable({
  /* can deliver the service */
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient, private messageService: MessageService) {

  }

  private userUrl = 'http://localhost:8080/Controller?action=GetFriends';
  private log(message: string) {
    this.messageService.add('Userservice: ' + message);
  }

  getUsers(): Observable<User[]> {
    this.log('test');
    /*return this.http.get<User[]>(this.userUrl).pipe(
      tap(users => this.log('fetched users')),
      catchError(this.handleError('getHeroes', []))
    ); */
    return this.http.get<User[]>(this.userUrl);
/*
    return of([
      {
        userId: 'Bram@ucll.be',
        firstName: 'Bram',
        lastName: 'VDD',
        role: 'lid',
        status: 'online',
        password: 't',
        salt: 't',
        },
      {
        userId: 'Wouter@ucll.be',
        firstName: 'Wouter',
        lastName: 'slegers',
        role: 'lid',
        status: 'ofline',
        password: 't',
        salt: 't',
      },
    ]);
    */
  }
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error); // log to console instead

      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
