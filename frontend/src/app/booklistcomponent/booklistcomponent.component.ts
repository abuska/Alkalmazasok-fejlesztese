import { BookServiceService } from './../book-service.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-booklistcomponent',
  templateUrl: './booklistcomponent.component.html',
  styleUrls: ['./booklistcomponent.component.css']
})
export class BooklistcomponentComponent implements OnInit {
  @Input() category: string;
  constructor(private bookService: BookServiceService) {
  }

  booklist = this.bookService.getBooksByCat(this.category);

  async ngOnInit() {
    if ( typeof(this.category) !== 'undefined') {
      this.booklist = this.bookService.getBooksByCat(this.category);
    }else {
      this.booklist = await this.bookService.getAllBooks();
      this.category = 'ÖSSZES';
    }
  }

}
