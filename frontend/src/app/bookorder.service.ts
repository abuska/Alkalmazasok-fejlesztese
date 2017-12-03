import { MOCKORDERS } from './models/mock-orders';
import { BookOrder } from './models/bookOrder';
import { Injectable } from '@angular/core';

@Injectable()
export class BookorderService {

  constructor() { }

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

  buyBook(bookid: number, userid: number) {
    const bookOrder = new BookOrder();
    bookOrder.book_id = bookid;
    bookOrder.user_id = userid;
    bookOrder.orderDate = new Date().toLocaleString();
    bookOrder.state = 'folyamatban';
    MOCKORDERS.push(bookOrder);
  }

}
