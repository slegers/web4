import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { AppRoutingModule } from './/app-routing.module';
import {HttpClientModule } from '@angular/common/http';
import {UserService} from './user.service';
import { UserLocalComponent } from './user-local/user-local.component';


@NgModule({
  /* lijst van directives en pipes (transformeert data) die beschikbaar moeten zijn in de app. */
  declarations: [
    AppComponent,
    UsersComponent,
    UserDetailComponent,
    MessagesComponent,
    UserLocalComponent,
  ],
  /* lijst van modules die beschikbaar moeten zijn in de app */
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  /** dependencies injectablex **/
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
