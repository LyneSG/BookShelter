import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BookEntity } from '../models/book.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BooksService {
  constructor(private http: HttpClient) {}

  getAllBooks(): Observable<BookEntity[]>{
    return this.http.get<BookEntity[]>('http://localhost:8080/books');
  }

  getBookByIsbn(bookIsbn: string): Observable<BookEntity>{
    return this.http.get<BookEntity>(`http://localhost:8080/books/${bookIsbn}`);
  }
}
