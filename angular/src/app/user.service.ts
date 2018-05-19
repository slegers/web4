import { Injectable } from '@angular/core';
import { User } from './user';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, take,tap } from 'rxjs/operators';
import { interval } from 'rxjs';
import {catchError} from 'rxjs/internal/operators';

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

  public userUrl = 'http://localhost:8080/Controller?action=GetUsers';
  private log(message: string) {
    this.messageService.add('Userservice: ' + message);
  }

  getUsers(): Observable<User[]> {
    this.log('fetch succeeded');
    return this.http.get<User[]>(this.userUrl);
  }
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error); // log to console instead

      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  updateUser (user: User): Observable<any> {
    return this.http.post(this.userUrl, user, httpOptions).pipe(
      tap(_ => this.log(`updated user id=${user.userId}`)),
      catchError(this.handleError<any>('updateHero'))
    );
  }
}
