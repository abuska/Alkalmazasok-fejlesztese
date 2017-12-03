import { User } from './models/user';
import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {
    activeUser = null;
    isLoggedIn = false;
    fakeUser: User;
  constructor() {
      this.fakeUser = new User();
      this.fakeUser.id = 1;
      this.fakeUser.email = 'a@b.hu';
      this.fakeUser.name = 'Kis Pista';
   }
 
  login(useremail: string, userpwd: string) {
      if ( useremail === 'a@b.hu' && userpwd === '123') {
            const user = this.fakeUser;
          this.activeUser = user;
          this.isLoggedIn  = true;
          return true;
      }else {
          return false;
      }
  }

  getUser(useremail: string) {
      const user = this.fakeUser;
      return user;
  }
}
