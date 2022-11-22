package com.book.author.book_author.Book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bservice;

    @PostMapping("/save")
    private ResponseEntity<?> insertBook( @RequestBody Book book){
        return new ResponseEntity<>(bservice.insertBook(book), HttpStatus.OK);
    }

//    @GetMapping("/getBooks")
//    private ResponseEntity<?> getBook(@RequestBody Book book){
//        return new ResponseEntity<>(bservice.getbooks(book),HttpStatus.OK);
//    }
    @GetMapping("/getBooks")
    private ResponseEntity<?>  getBook(){
        return new ResponseEntity<>(bservice.getbooks(),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{bookid}")
    private  ResponseEntity deleteBook(@PathVariable Integer bookid){
        return new ResponseEntity(bservice.delete(bookid),HttpStatus.OK);
    }

    @PutMapping("edit/{bookid}")
    private  ResponseEntity<?> putBook(@PathVariable("bookid") int bookid, @RequestBody Book book){
      return  new ResponseEntity<>(bservice.edit(bookid,book),HttpStatus.OK);
    }

}
