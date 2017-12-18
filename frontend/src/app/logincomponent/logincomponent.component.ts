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
    // console.log("19.sor", this.activeUser);
  }

  async onLogin(username: string, userpwd: string) {
    this.loginAttempt = await this.loginService.login(username, userpwd);
    if (this.loginAttempt) {
      this.validLogin = true;
      this.isLoggedin = true;
      this.loginService.isLoggedIn = true;
      this.activeUser = this.loginService.activeUser;
    //  console.log(this.activeUser);
    }
  }

    onRegister() {
      this.router.navigate(['registration' ]);
    }

    onLogout() {
      this.isLoggedin = false;
      this.validLogin = true;
      this.loginAttempt = null;
      this.activeUser = null;
      this.loginService.activeUser = null;
      this.loginService.isLoggedIn = false;
      this.router.navigate(['login']);
    }

}
