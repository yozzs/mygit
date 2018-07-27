// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Book.java

package com.youzi.domain;

public class Book {

	private String id;
	private String bookname;
	private String author;
	private String press;
	private double price;
	private String description;
	private String imguri;

	public Book() {
	}

	public Book(String id, String bookname, String author, String press,
			double price, String description, String imguri) {
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.press = press;
		this.price = price;
		this.description = description;
		this.imguri = imguri;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImguri() {
		return imguri;
	}

	public void setImguri(String imguri) {
		this.imguri = imguri;
	}
}
