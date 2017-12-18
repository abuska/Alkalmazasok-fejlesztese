import { MOCKORDERS } from './models/mock-orders';
import { BookOrder } from './models/bookOrder';
import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
@Injectable()
export class BookorderService {

  baseUrl = 'http://localhost:8080/';
  constructor(private http: Http) {
   }

  getAllBookOrders( ) {
    return MOCKORDERS;
  }
  getBookOrders(userID: number) {
   let bookOrders: BookOrder[] = [];
    for (let i = 0; i < MOCKORDERS.length; ++i) {
        if (MOCKORDERS[i].user_id === userID) {
          bookOrders.push( MOCKORDERS[i] );
        }
    }
    return bookOrders;
  }

 async buyBook(bookid: number, userid: number) {
    const bookOrder = new BookOrder();
    bookOrder.book_id = bookid;
    bookOrder.user_id = userid;
    bookOrder.orderDate = new Date().toLocaleString().toLocaleLowerCase();
    bookOrder.state = 'folyamatban';
    MOCKORDERS.push(bookOrder);
 console.log(bookOrder);
   const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
     const promise = await new Promise((resolve, reject) => {
      this.http.post(this.baseUrl + 'bookorder/new',   JSON.stringify(bookOrder),  options)
        .toPromise()
        .then(
          res => { // Success
         //   alert(res.text());
            resolve();
          }
        );
    });


  }

}
