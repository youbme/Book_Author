package com.book.author.book_author.Author;

import com.book.author.book_author.Book.Book;
import com.book.author.book_author.Book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authRepo;
    @Autowired
    private BookRepository bookRepo;

    public Author saveAuthor(Author author) {
        return authRepo.save(author);

    }

    public Long deleteAuthor(Long authId) {
        Long id = authId;
        authRepo.deleteById(id.intValue());
        return id;
    }

    public List<Author> getAuthor() {
        return authRepo.findAll();
    }

    public ResponseEntity<Book> editAuthor(int authid, Author author) {

        Optional<Author> result = authRepo.findById(authid);
        if (result.isPresent()) {
            Author _author = result.get();
            _author.setFirstName(author.getFirstName());
            _author.setLastName(author.getLastName());
            _author.setCountry();
            return new ResponseEntity(authRepo.save(_author), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Author authorwrotebook(int authid, int bookid) {

        Set<Book> bookset = null;
        Author author = authRepo.findById(authid).get();
        Book book = bookRepo.findById(bookid).get();
        bookset = author.getBook();
        bookset.add(book);
        author.setBook(bookset);
        return authRepo.save(author);
    }


    public float ratings(int authid) {

        Author author = authRepo.findById(authid).get();
        Set<Book> bset = author.getBook();
        int s = bset.size();
        int d = 0;
        float sum = 0;
        for (Book b : bset) {
            String c = b.getRatings();
            d = Integer.parseInt(c);
            sum = sum + d;
        }
        float avg = sum/s;
        return avg;
    }

    public String bestseller(){

        List<Author> a =  authRepo.findAll();
 Set<Book> bset ;
 Author author = new Author();
 ArrayList<String> list = new ArrayList<>() ;
for (int i=0; i<a.size(); i++){
    author = a.get(i);
    bset = author.getBook();
    int d =0;
    int sum=0;
    for(Book b : bset){
        String c = b.getRatings();
        d = Integer.parseInt(c);
        sum = sum+d;
    }
    int s=bset.size();
    int avg =sum/s;
    list.add(avg + ", "+author.getFirstName()+" "+author.getLastName());
}
        String min = Collections.min(list);
        String max = Collections.max(list);

        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        for(int i =0; i<ar.size();i++){
            for(int j=0; j<ar.size();i++) {
                if (ar.get(i) > ar.get(2)) {
                    int temp;
                }
                }
            }
        return "Rating: "+max+": Best Selling Author.\n"+ "Rating: " + min+": Worst Selling Author.";
    }


//*************---------**********
    public List<Integer> deleteAuthors(List<Integer> ids) {
            for (Integer i: ids) {
                authRepo.deleteById(i);
            }
        return ids;
    }
    int[] test(){
        int a[]={3,4,5,2};
        int temp= 0;
        for(int i=0; i<=3; i++){
            for (int j=0; j<=3;j++){
                if(a[i]<a[j]){
                    temp = a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }

        return a;
    }

    int reverse(int nums) {
        int reverse = 0;
        int value= nums;
        while(value>0) {

            int rem = value % 10;
            reverse = reverse * 10 + rem;
            value = value / 10;

        }
        return reverse;
    }
    int maximum(){

        int a[] = {4,9,6,8,10,200};
        int max=a[0];
        int temp;
         for (int i=0; i<a.length; i++) {
            if(a[i] > max){
                max=a[i];
            }
         }
        return max;
    }
    int inertial(int[] init){

        int m=0;
        int n;
        int odd;
        int a[]=init;

        for(int i=0; i<a.length; i++){
            n = a[i];
            odd= n%2;
            if ( odd != 0){

                m =1;
            }

        }
        int max=a[0];
        if(m==1){

             for(int i=0; i<a.length; i++){
                 if(a[i]>max){
                     max=a[i];
                 }
             }
             int mod = max%2;
             if(mod == 0){
                 m=1;
             }
             else m=0;
        }

        //thirdd***********part
        int sec = 0;
        if(m==1){

            int temp;
            for(int i=0; i<a.length; i++){
                for (int j=0; j<a.length;j++){
                    if(a[i]<a[j]){
                        temp = a[i];
                        a[i]=a[j];
                        a[j]=temp;
                    }
                }
            }
                    for(int k=0; k<a.length; k++){

                        if(a[k]%2==0 && a[k]<max){
                            sec = a[k];
                           // System.out.println(sec);
                        }


                for(int l=0; l<a.length; l++){


                    if( a[l]%2!=0 && sec>a[l]){
                        m= 0;
                        break;
                    }
                    else m= 1;
                }

            }
            //m= a[a.length-2];




        }


        return m;
    }



    public ArrayList getTarget() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int[] a= {-4, -2, -110, -8};
        int target = -12;

        for(int i=0; i<a.length; i++){
            for (int j=0; j<a.length; j++) {
                if((a[i]+a[j])== target && a[i]!=a[j]){
                    list.add(a[i]);
                    list.add(a[j]);
                    return  list;
                }
            }
        }

        list.forEach(System.out::println);

        return list;
    }


}