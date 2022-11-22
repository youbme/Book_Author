package com.book.author.book_author.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public Book insertBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> getbooks(){
       return bookRepo.findAll();
    }

    public int delete(int bookid){
         bookRepo.deleteById(bookid);
        return bookid;
    }
    public ResponseEntity<Book> edit(Integer bookid, Book book){
        Optional<Book> result = bookRepo.findById(bookid);
        if(result.isPresent()) {
            Book _book = result.get();
            _book.setISBN(book.getISBN());
            _book.setCategory(book.getCategory());
            _book.setRatings(book.getRatings());
            _book.setPrice(book.getPrice());
            return  new ResponseEntity<>(bookRepo.save(_book), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
