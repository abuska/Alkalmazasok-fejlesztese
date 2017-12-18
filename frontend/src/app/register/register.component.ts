import { User } from './../models/user';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public isLoggedin = false;
  validLogin = true;
  loginAttempt = null;
  activeUser = null;
  constructor(public loginService: LoginService,
              private router: Router,
              private location: Location) { }

  ngOnInit() {
    this.activeUser = this.loginService.activeUser;
    console.log(this.activeUser);
  }

  async onRegister(useremail: string,
             fullname: string,
             address: string,
             username: string,
             password: string
            ) {
    const user = new User();
      user.address = address;
      user.email = useremail;
      user.name = fullname;
      user.password = password;
      user.username = username;
      const regData = await this.loginService.register(user);
      if ( regData === '' || regData === null) {
        this.router.navigate(['login' ]);
      } else {
       alert(regData);
      }
  }

}
