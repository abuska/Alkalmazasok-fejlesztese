import { BookServiceService } from './../book-service.service';
import { User } from './../models/user';
import { BookOrder } from '../models/bookOrder';
import { BookorderService } from './../bookorder.service';
import { LoginService } from './../login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bookorder',
  templateUrl: './bookorder.component.html',
  styleUrls: ['./bookorder.component.css']
})
export class BookorderComponent implements OnInit {

  constructor(private loginService: LoginService,
              private bookOrderService: BookorderService,
              private bookService: BookServiceService) { }
  bookorders: BookOrder[] = [];
  activeUser: User;
  booktitles: string[] = [];
  ngOnInit() {
    this.bookorders = this.bookOrderService.getBookOrders(this.loginService.activeUser.id);
    for ( let i = 0; i < this.bookorders.length; ++i) {
        let book = this.bookService.getBook(this.bookorders[i].book_id);
        this.booktitles.push(book.title);
    }
    this.activeUser = this.loginService.activeUser;
  }

}
