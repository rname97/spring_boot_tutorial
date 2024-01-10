package com.blackcode.springbootcurdsimple.controllers;

import com.blackcode.springbootcurdsimple.payload.RequestBook;
import com.blackcode.springbootcurdsimple.payload.ResponseBook;
import com.blackcode.springbootcurdsimple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/getAllBook")
    public List<ResponseBook> getListALl(){
        return bookService.getListALl();
    }

    @GetMapping(value = "/getValue/{id}")
    public ResponseBook getValue(@PathVariable("id") Long id){
        return bookService.getValueBook(id);
    }

    @PostMapping(value = "/addBook")
    public ResponseBook addBook(@RequestBody RequestBook requestBook){
        return bookService.addBook(requestBook);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseBook updateBook(@PathVariable("id") Long id, @RequestBody RequestBook requestBook){
        return bookService.updateBook(id, requestBook);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        System.out.println("Book Berhasil Delete : "+id);
    }
}
