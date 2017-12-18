import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Book } from './models/book';
import { BOOKS } from './models/mock-books';

@Injectable()
export class BookServiceService {
    baseUrl = 'http://localhost:8080/';
 constructor(private http: Http) { }

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
    async getBookByTitle(bookTitle: string) {
        const headers = new Headers({ 'Content-Type': 'application/json' });
        const options = new RequestOptions({ headers: headers });
        let retData = '';
         const promise = await new Promise((resolve, reject) => {
          this.http.get(this.baseUrl + 'book/listall')
            .toPromise()
            .then(
              res => { // Success
             //   alert(res.text());
                retData = JSON.parse(res.text());
                resolve();
              }
            );
        });
          return retData;
    }

    async  getAllBooks() {
        const headers = new Headers({ 'Content-Type': 'application/json' });
        const options = new RequestOptions({ headers: headers });
        let retData: Book[] = [];
        const promise = await new Promise((resolve, reject) => {
          this.http.get(this.baseUrl + 'book/listall')
            .toPromise()
            .then(
              res => { // Success
             //   alert(res.text());
                const resArry = JSON.parse(res.text());
                console.log(resArry);
                for ( const result of resArry){
                    retData.push(result);
                }
                resolve();
              }
            );
        });
          return retData;
    }

}
