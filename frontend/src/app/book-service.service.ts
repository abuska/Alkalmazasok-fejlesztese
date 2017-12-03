import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Book } from './models/book';
import { BOOKS } from './models/mock-books';

@Injectable()
export class BookServiceService {

 constructor() { }

 getBooks(): Observable<Book[]> {
   return of(BOOKS);
 }

 getBooksByCat(category: string) {
    const filtBooks: Book[] = [];
    for ( let i = 0; i < BOOKS.length; ++i) {
        if ( BOOKS[i].category === category) {
            filtBooks.push(BOOKS[i]);
        }
    }
    return filtBooks;
 }

 getBook(id: number) {
    const filtBook =  BOOKS.find(book => book.id === id);
    return filtBook;
 }
    getBookByTitle(bookTitle: string) {
        return BOOKS.find(book => book.title === bookTitle);
    }

    getAllBooks() {
        return BOOKS;
    }

}
