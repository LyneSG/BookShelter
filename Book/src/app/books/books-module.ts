import { NgModule } from '@angular/core';
import { AsyncPipe, CommonModule, UpperCasePipe } from '@angular/common';
import { BooksRoutingModule } from './books-routing.module';
import { BookComponent } from './book/book.component';
import { BookListComponent } from './book-list/book-list.component';

@NgModule({
  declarations: [
    BookComponent,
    BookListComponent,
  ],
  imports: [
    CommonModule,
    BooksRoutingModule,
    UpperCasePipe,
    AsyncPipe
  ],
  exports: [],
})
export class BooksModule {}
