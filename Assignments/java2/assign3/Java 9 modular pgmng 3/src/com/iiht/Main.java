package com.iiht;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iiht.data.Library;
import com.iiht.model.Book;
import com.iiht.service.BookService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Book> bList=new ArrayList<Book>();
		int minBooks=6;
		Book[] book=new Book[minBooks];
		book[0]=new Book(1,"Java","James Gosling");
		book[1]=new Book(2,"Python","Guido van Rossum");
		book[2]=new Book(5,"C","Dennis Ritchie");
		book[3]=new Book(3,"C++","Bjane Stroustrup");
		book[4]=new Book(6,"Java Script","Brendan Eich");
		book[5]=new Book(4,"PHP","Rasmus Lerdorf");
		for(int i=0;i<minBooks;i++){
			bList.add(book[i]);
		}
		Library library=new Library(bList);
		System.out.println(String.format("%-10s %-10s","","Menu"));
		System.out.println("1.Display Book Number-wise");
		System.out.println("2.Display Book Title-wise");
		System.out.println("3.Display Book Author-wise");
		System.out.println("4.Exit");
		System.out.println("Enter choice(1-4):");
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		System.out.println(String.format("%-10s %-35s %-20s","Book Id","Book Title","Book Author"));
		BookService bs=new BookService();
		switch(input){
			case 1: List<Book> numFilteredList= bs.arrangeBooksNumberWise(library.getAllBooks());
					for(Book e : numFilteredList) {
				         System.out.println(String.format("%-10s %-35s %-20s",e.getData()[0], e.getData()[1], e.getData()[2]));
				      }
					break;
			case 2: List<Book> titleFilteredList=bs.arrangeBooksTitleWise(library.getAllBooks());
					for(Book e : titleFilteredList) {
						System.out.println(String.format("%-10s %-35s %-20s",e.getData()[0], e.getData()[1], e.getData()[2]));
				      }
					break;
			case 3: List<Book> authorFilteredList=bs.arrangeBooksAuthorWise(library.getAllBooks());
					for(Book e : authorFilteredList) {
						System.out.println(String.format("%-10s %-35s %-20s",e.getData()[0], e.getData()[1], e.getData()[2]));
				      }
					break;
			default: System.out.println("Good bye!!");
		}
	}
}
