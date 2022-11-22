package com.book.author.book_author.Author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    void deleteAllByAuthorId(Integer ids);

    void findAllByAuthorId(int[] a);



}
