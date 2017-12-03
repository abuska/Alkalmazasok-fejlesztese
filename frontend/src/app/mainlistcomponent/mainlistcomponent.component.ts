import { BookServiceService } from '../book-service.service';
import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book';

@Component({
  selector: 'app-mainlistcomponent',
  templateUrl: './mainlistcomponent.component.html',
  styleUrls: ['./mainlistcomponent.component.css']
})
export class MainlistcomponentComponent implements OnInit {
  usedCategories = ['DRAMA', 'COMEDY', 'HOBBY'];
    constructor() {
   }

  ngOnInit() {
  }
}
