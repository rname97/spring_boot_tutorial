package com.blackcode.springbootcurdsimple.service;


import com.blackcode.springbootcurdsimple.models.Book;
import com.blackcode.springbootcurdsimple.payload.RequestBook;
import com.blackcode.springbootcurdsimple.payload.ResponseBook;

import java.util.List;

public interface BookService {

    List<ResponseBook> getListALl();
    ResponseBook getValueBook(Long id);

    ResponseBook addBook(RequestBook requestBook);

    ResponseBook updateBook(Long id, RequestBook requestBook);

    void deleteBookById(Long id);
}
