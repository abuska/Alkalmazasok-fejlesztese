import { BookorderService } from './../bookorder.service';
import { LoginService } from './../login.service';
import { BookServiceService } from './../book-service.service';
import { Book } from './../models/book';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-bookcomponent',
  templateUrl: './bookcomponent.component.html',
  styleUrls: ['./bookcomponent.component.css']
})

export class BookcomponentComponent implements OnInit {
  @Input() book: Book;
  constructor(private route: ActivatedRoute,
    private bookService: BookServiceService,
    private bookOrderService: BookorderService,
    private location: Location,
    private loginService: LoginService,
    private router: Router
    ) { }
   isLoggedIn: boolean;
  ngOnInit() {
    this.getBook();
    this.isLoggedIn = this.loginService.isLoggedIn;
  }
  getBook(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.book = this.bookService.getBook(id);
  }

  onBuy(book: Book) {
    this.bookOrderService.buyBook(book.id, this.loginService.fakeUser.id);
    this.router.navigate(['login']);
  }

  goBack(): void {
    this.location.back();
  }
}
