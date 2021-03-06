/* bcabcl
 *
 * Copyright (c) 2018 Tushar Girase All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ecabcl
 */
package com.abcl.libmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcl.libmgmt.models.Book;
import com.abcl.libmgmt.repository.BookRepository;

/**
 *
 */
@Service("bookService")
public class BookService implements IBookService {

    @Autowired
    BookRepository bookRepository;

    /*
     * (non-Javadoc)
     *
     * @see com.abcl.libmgmt.service.IBookService#getAllBooks()
     */
    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        Iterable<Book> itr = bookRepository.findAll();
        if (null != itr) {
            for (Book book : itr) {
                books.add(book);
            }
        }
        return books;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.abcl.libmgmt.service.IBookService#saveBookRecord()
     */
    @Override
    public Book saveBookRecord(Book book) {
        return bookRepository.save(book);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.abcl.libmgmt.service.IBookService#findBookByIsbinNo(java.lang.String)
     */
    @Override
    public Book findBookByIsbinNo(String isbinNo) {
        return bookRepository.findByIsbin(isbinNo);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.abcl.libmgmt.service.IBookService#deleteBookByIsbin(java.lang.String)
     */
    @Override
    public void deleteBookByIsbin(String isbinNo) {
        Book bookRecordToDelete = bookRepository.findByIsbin(isbinNo);
        bookRepository.delete(bookRecordToDelete);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.abcl.libmgmt.service.IBookService#findBookByName()
     */
    @Override
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findByBookTitle(title);
    }

}
