package com.iiht.service;

import java.util.Collections;
import java.util.List;

import com.iiht.model.Book;

public class BookService {
	public List<Book> arrangeBooksNumberWise(List<Book> bookList){
		Collections.sort(bookList, (p1, p2) -> {
	         return p1.getData()[0].compareTo(p2.getData()[0]); 
	      });
		return bookList;
	}
	
	public List<Book> arrangeBooksTitleWise(List<Book> bookList){
		Collections.sort(bookList, (p1, p2) -> {
	         return p1.getData()[1].compareTo(p2.getData()[1]); 
	      });
		return bookList;
	}
	
	public List<Book> arrangeBooksAuthorWise(List<Book> bookList){
		Collections.sort(bookList, (p1, p2) -> {
	         return p1.getData()[2].compareTo(p2.getData()[2]); 
	      });
		return bookList;
	}
}
