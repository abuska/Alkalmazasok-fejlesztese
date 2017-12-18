import { RegisterComponent } from './register/register.component';
import { MainlistcomponentComponent } from './mainlistcomponent/mainlistcomponent.component';
import { LogincomponentComponent } from './logincomponent/logincomponent.component';
import { BooklistcomponentComponent } from './booklistcomponent/booklistcomponent.component';
import { BookcomponentComponent } from './bookcomponent/bookcomponent.component';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full' },
  { path: 'index', component: MainlistcomponentComponent },
  { path: 'book/:id', component: BookcomponentComponent },
  { path: 'books', component: BooklistcomponentComponent },
  { path: 'login', component: LogincomponentComponent },
  { path: 'registration', component: RegisterComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
