package com.iiht.data;

import java.util.ArrayList;
import java.util.List;

import com.iiht.model.Book;

public class Library {
	private static List<Book> bookList;
	public Library(List<Book> bookList){
		this.bookList=bookList;
	}
	public static List<Book> getAllBooks(){
		return bookList;
	}
}
//static block to store at least 6 books object into the list.