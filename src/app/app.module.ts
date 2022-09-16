import {MatButtonModule} from '@angular/material/button';
import { UserformComponent } from './userform/userform.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { BookComponent } from './Book/book.component';
import { SingupComponent } from './pages/singup/singup.component';
const routes: Routes = [
  { path: 'userform', component: UserformComponent }
]
@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    BookComponent,
    SingupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule, HttpClientModule, RouterModule.forRoot(routes), BrowserAnimationsModule,
    MatButtonModule,MatInputModule,MatFormFieldModule
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
