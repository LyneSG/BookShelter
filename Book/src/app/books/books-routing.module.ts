import { RouterModule, Routes } from '@angular/router';
import { NewBookComponent } from './new-book/new-book.component';
import { SingleBookComponent } from './single-book/single-book.component';
import { BookListComponent } from './book-list/book-list.component';
import { NgModule } from '@angular/core';

const routes: Routes = [
  {path: 'create', component: NewBookComponent},
  {path: ':isbn', component: SingleBookComponent},
  {path: '', component: BookListComponent},
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BooksRoutingModule { }
