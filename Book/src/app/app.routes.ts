import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/components/landing-page-component/landing-page-component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
  {path: 'books', loadChildren: () => import('./books/books-module').then(m => m.BooksModule)},
  {path: '', component : LandingPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
