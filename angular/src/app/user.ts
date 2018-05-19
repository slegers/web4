import {st} from '@angular/core/src/render3';

export interface User {
  userId: string;
  password: string;
  salt: string;
  firstName: string;
  lastName: string;
  role: string;
  status: string;
}
