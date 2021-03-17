package com.iiht.model;

public class Book {
	private int bookNumber;
	private String bookTitle;
	private String author;
	public Book(int bn, String bt, String a){
		this.bookNumber=bn;
		this.bookTitle=bt;
		this.author=a;
	}
	public String[] getData(){
		String[] data =new String[3];
		data[0]=Integer.toString(this.bookNumber);
		data[1]=this.bookTitle;
		data[2]=this.author;
		return data;
	}
	public String toString(){
		return String.format("%-10s %-35s %-20s",this.bookNumber,this.bookTitle,this.author);
	}
}
