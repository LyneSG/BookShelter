import { Component, OnInit } from '@angular/core';
import { BookEntity } from '../../core/models/book.model';
import { Observable } from 'rxjs';
import { BooksService } from '../../core/service/books.service';
import { BookComponent } from '../book/book.component';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.scss',
  standalone: false
})
export class BookListComponent implements OnInit {
  books$!: Observable<BookEntity[]>;

  constructor(private bookService: BooksService) {}

  ngOnInit(): void {
    this.books$ = this.bookService.getAllBooks();
  }
}
