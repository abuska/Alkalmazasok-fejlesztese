import { BookorderService } from './bookorder.service';
import { LoginService } from './login.service';
import { BookServiceService } from './book-service.service';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {HttpClientModule} from '@angular/common/http';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HeadercomponentComponent } from './headercomponent/headercomponent.component';
import { MainlistcomponentComponent } from './mainlistcomponent/mainlistcomponent.component';
import { BookcomponentComponent } from './bookcomponent/bookcomponent.component';
import { BooklistcomponentComponent } from './booklistcomponent/booklistcomponent.component';
import { LogincomponentComponent } from './logincomponent/logincomponent.component';
import { AppRoutingModule } from './app-routing.module';
import { BookorderComponent } from './bookorder/bookorder.component';
import { RegisterComponent } from './register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    HeadercomponentComponent,
    MainlistcomponentComponent,
    BookcomponentComponent,
    BooklistcomponentComponent,
    LogincomponentComponent,
    BookorderComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [BookServiceService,
    LoginService,
    BookorderService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
