package com.book.author.book_author.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authService;

    @PostMapping("/save")
    public ResponseEntity<?> saveAuthor(@RequestBody Author authobj){
        return new ResponseEntity<>(authService.saveAuthor(authobj), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{authId}")
    public ResponseEntity deleteAuthor(@PathVariable Long authId){
        return new ResponseEntity( authService.deleteAuthor(authId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteAuthors")
    public ResponseEntity<?>deleteAuthors(@RequestBody List<Integer> ids){
     return new ResponseEntity<>(authService.deleteAuthors(ids),HttpStatus.OK);
    }

    @GetMapping("getAuthor")
    private ResponseEntity<?>getAuthor(){
        return new ResponseEntity<>(authService.getAuthor(),HttpStatus.OK);
    }

    @PutMapping("/edit/{authid}")
    private ResponseEntity<?> editAuthor(@PathVariable("authid") int authid, @RequestBody Author author){
        return new ResponseEntity<>(authService.editAuthor(authid,author),HttpStatus.OK);
    }
    @PutMapping("/{authid}/book/{bookid}")
     private ResponseEntity<?> join (  @PathVariable int authid,
        @PathVariable int bookid
    ){
        return new ResponseEntity<>(authService.authorwrotebook(authid,bookid),HttpStatus.OK);

    }

    @GetMapping("/ratings/{authid}")
    private ResponseEntity<?> ratings(@PathVariable int authid){
        return new ResponseEntity<>(authService.ratings(authid),HttpStatus.OK);
    }
    @GetMapping("/bestseller")
    private  ResponseEntity bestseller(){
        return new ResponseEntity<>(authService.bestseller(),HttpStatus.OK);
    }
    @GetMapping("/test")
    private ResponseEntity<?> test(){
        return new ResponseEntity<>(authService.test(),HttpStatus.OK);
    }

    @GetMapping("/reverse/{num}")
    private  ResponseEntity<?> reverse(@PathVariable int num){
        return new ResponseEntity<>(authService.reverse(num),HttpStatus.OK);
    }

    @GetMapping("/max")
        private ResponseEntity<?> maximum(){
        return new ResponseEntity<>(authService.maximum(),HttpStatus.OK);
        }

    @GetMapping("/inertial")
    private ResponseEntity<?> inertial(@RequestBody int[] init){
        return new ResponseEntity<>(authService.inertial(init),HttpStatus.OK);
    }
    @GetMapping("/gettarget")
    private ResponseEntity<?> gettarget(){
        return  new ResponseEntity<>(authService.getTarget(),HttpStatus.OK);
    }

}
