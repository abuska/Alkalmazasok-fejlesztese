
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { User } from './models/user';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
@Injectable()
export class LoginService {
    activeUser = null;
    isLoggedIn = false;
    fakeUser: User;
    baseUrl = 'http://localhost:8080/';
  constructor(private http: Http) {
      this.fakeUser = new User();
   }

  async register( user: User ) {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    let retData = '';
    const promise = await new Promise((resolve, reject) => {
      this.http.post(this.baseUrl + 'auth/registration', JSON.stringify(user), options)
        .toPromise()
        .then(
          res => { // Success
         //   alert(res.text());
            retData = (res.text());
            resolve();
          }
        );
    });
      return retData;
  }


  async login( useremail: string, userpwd: string ) {
        const headers = new Headers({ 'Content-Type': 'application/json' });
        const options = new RequestOptions({ headers: headers });
        const payload = {
          username: useremail,
          password: userpwd
        };
        let retData = '';
        const promise = await new Promise((resolve, reject) => {
            this.http.post(this.baseUrl + 'auth/login',
           JSON.stringify(payload),
            options)
            .toPromise()
            .then(
              res => { // Success
                retData = JSON.parse(res.text());
                this.activeUser = retData;
                resolve();
              }
            );
         });
        return retData;
      }

  async getUser(useremail: string) {
    if ( this.isLoggedIn ) {

    /*let retUser;
    const promise = await new Promise((resolve, reject) => {
        this.http.post(this.baseUrl + 'auth/user/?id='+, JSON.stringify(payload), options)
        .toPromise()
        .then(
          res => { // Success
         alert(res.text());
            //retData = (res.text());
            resolve();
          }
        );
     });
    return 'retData';

  }else{*/
    return false;
  }
  }
}
