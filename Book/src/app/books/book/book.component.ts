import { UpperCasePipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { BookEntity } from '../../core/models/book.model';
import { BooksService } from '../../core/service/books.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrl: './book.component.scss',
  standalone: false
})
export class BookComponent implements OnInit {
  @Input() book!: BookEntity

  constructor(
    private bookService: BooksService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onViewBook(): void {
    this.router.navigateByUrl(`/books/${this.book.isbn}`);
  }
}
