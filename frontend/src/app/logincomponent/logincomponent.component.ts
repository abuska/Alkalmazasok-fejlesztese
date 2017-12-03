import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
@Component({
  selector: 'app-logincomponent',
  templateUrl: './logincomponent.component.html',
  styleUrls: ['./logincomponent.component.css']
})
export class LogincomponentComponent implements OnInit {
  public isLoggedin = false;
  validLogin = true;
  loginAttempt = null;
  activeUser = null;
  constructor(public loginService: LoginService,
              private router: Router) { }

  ngOnInit() {
    this.activeUser = this.loginService.activeUser;
    console.log(this.activeUser);
  }

  onLogin(useremail: string, userpwd: string) {
    this.loginAttempt =  this.loginService.login(useremail, userpwd);
    if (this.loginAttempt) {
      this.validLogin = true;
      this.isLoggedin = true;
      this.activeUser = this.loginService.getUser(useremail);
      console.log(this.activeUser);
    }
  }
    onLogout() {
      this.router.navigate(['login' ]);
      this.isLoggedin = false;
      this.validLogin = true;
      this.loginAttempt = null;
      this.activeUser = null;
      this.loginService.activeUser = null;
      this.loginService.isLoggedIn = false;
      this.router.navigate(['login']);
    }

}
