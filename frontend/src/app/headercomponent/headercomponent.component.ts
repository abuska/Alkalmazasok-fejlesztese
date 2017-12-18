import { BookServiceService } from './../book-service.service';
import { Component, OnInit } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-headercomponent',
  templateUrl: './headercomponent.component.html',
  styleUrls: ['./headercomponent.component.css']
})
export class HeadercomponentComponent implements OnInit {

  constructor(public loginService: LoginService,
              public router: Router,
              private bookService: BookServiceService) { }

  ngOnInit() {
  }


  async onSearch(bookTitle: string) {
    /*
     const getbook = this.bookService.getBookByTitle(bookTitle);
      if ( typeof (getbook) !== 'undefined')  {
        this.router.navigate(['book/' + bookTitle ]);
      }
      */
      const getbook = this.bookService.getBookByTitle(bookTitle);
      if ( typeof (getbook) !== 'undefined')  {
        console.log(getbook);
        //this.router.navigate(['book/' + bookTitle ]);
      }
  }

  getIsLoggedIn() {
     console.log(this.loginService.activeUser);
  }


}
