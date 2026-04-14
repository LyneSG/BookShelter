import { RouterModule, Routes } from '@angular/router';
import { NewBook } from './new-book/new-book';
import { SingleBook } from './single-book/single-book';
import { BookList } from './book-list/book-list';
import { NgModule } from '@angular/core';

const routes: Routes = [
  {path: '/create', component: NewBook},
  {path: '/:isbn', component: SingleBook},
  {path: '', component: BookList},
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BooksRoutingModule { }
