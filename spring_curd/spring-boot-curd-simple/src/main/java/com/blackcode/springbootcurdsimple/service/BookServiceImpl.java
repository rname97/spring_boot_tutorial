package com.blackcode.springbootcurdsimple.service;

import com.blackcode.springbootcurdsimple.models.Book;
import com.blackcode.springbootcurdsimple.payload.RequestBook;
import com.blackcode.springbootcurdsimple.payload.ResponseBook;
import com.blackcode.springbootcurdsimple.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<ResponseBook> getListALl() {
        List<Book> dataBook = bookRepository.findAll();
        List<ResponseBook> rtnTemp = new ArrayList<>();

        for (Book tempBook : dataBook){
            ResponseBook responseBook = ResponseBook.builder()
                    .id(tempBook.getId())
                    .bookName(tempBook.getBookName())
                    .bookCategory(tempBook.getBookCategory())
                    .bookPenerbit(tempBook.getBookPenerbit())
                    .bookPengarang(tempBook.getBookPengarang())
                    .bookTahunPenerbit(tempBook.getBookTahunPenerbit())
                    .build();
            rtnTemp.add(responseBook);
        }
        return rtnTemp;
    }

    @Override
    public ResponseBook getValueBook(Long id) {
        Optional<Book> dtBook = bookRepository.findById(id);
        Book tempBook = dtBook.get();
        ResponseBook rtnTemp = ResponseBook.builder()
                .id(tempBook.getId())
                .bookName(tempBook.getBookName())
                .bookCategory(tempBook.getBookCategory())
                .bookPenerbit(tempBook.getBookPenerbit())
                .bookPengarang(tempBook.getBookPengarang())
                .bookTahunPenerbit(tempBook.getBookTahunPenerbit())
                .build();
        return rtnTemp;
    }

    @Override
    public ResponseBook addBook(RequestBook requestBook) {
        Book book = Book.builder()
                .bookName(requestBook.getBookName())
                .bookCategory(requestBook.getBookCategory())
                .bookPenerbit(requestBook.getBookPenerbit())
                .bookPengarang(requestBook.getBookPengarang())
                .bookTahunPenerbit(requestBook.getBookTahunPenerbit())
                .build();
        Book saveBook = bookRepository.save(book);
        ResponseBook responseBook = ResponseBook.builder()
                .id(saveBook.getId())
                .bookName(saveBook.getBookName())
                .bookCategory(saveBook.getBookCategory())
                .bookPengarang(saveBook.getBookPengarang())
                .bookPenerbit(saveBook.getBookPenerbit())
                .bookTahunPenerbit(saveBook.getBookTahunPenerbit())
                .build();
        return responseBook;
    }

    @Override
    public ResponseBook updateBook(Long id, RequestBook requestBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.get();

        book.setBookName(requestBook.getBookName());
        book.setBookCategory(requestBook.getBookCategory());
        book.setBookPenerbit(requestBook.getBookPenerbit());
        book.setBookPengarang(requestBook.getBookPengarang());
        book.setBookTahunPenerbit(requestBook.getBookTahunPenerbit());

        Book updateBook = bookRepository.save(book);
        ResponseBook rtnBook = ResponseBook.builder()
                .id(updateBook.getId())
                .bookName(updateBook.getBookName())
                .bookCategory(updateBook.getBookCategory())
                .bookPengarang(updateBook.getBookPengarang())
                .bookPenerbit(updateBook.getBookPenerbit())
                .bookTahunPenerbit(updateBook.getBookTahunPenerbit())
                .build();

        return rtnBook;
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
