package com.springbootRestAPI.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bookId")
	private int Id;
	private String Title;
	@OneToOne(cascade = CascadeType.ALL)
//	@JsonManagedReference
	private Author Author;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String title,Author author) {
		super();
		Id = id;
		Title = title;
		Author = author;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Author getAuthor() {
		return Author;
	}

	public void setAuthor(Author author) {
		Author = author;
	}

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", Title=" + Title + ", Author=" + Author + "]";
	}
	

}
