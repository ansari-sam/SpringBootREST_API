package com.springbootRestAPI.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootRestAPI.dao.BookRepository;
import com.springbootRestAPI.entities.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
//	private static List<Book> list=new ArrayList<Book>();
//	
//	static {
//		list.add(new Book(34,"Java Booster","XYZ"));
//		list.add(new Book(23,"Python Handler","ABC"));
//		list.add(new Book(31,"Java Graper","OPQ"));
//		list.add(new Book(51,"Eclipse Master","DEF"));
//	}
	
	public List<Book> getAllBooks(){
		List<Book> list =(List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	public Book getSingleBook(int id) {
//		Book book=new Book();
//		 try {
//			 list.forEach(b->{
//					if(b.getId()==id) {
//						book.setId(b.getId());
//						book.setName(b.getName());
//						book.setAuthor(b.getAuthor());
//					}
//				});
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return book;
		return this.bookRepository.findById(id);
	}
	
	public Book addBook(Book b) {
//		this.list.add(b);
//		return b;
		return this.bookRepository.save(b);
	}
	
	public void deleteBook(int id) {
//		List<Book> list1=new ArrayList<Book>();
//		list.forEach(b->{
//			if(b.getId()!=id) {
//				list1.add(b);
//			}
//		});
//		list=list1;
		this.bookRepository.deleteById(id);
	}

	public void updateBook(Book bookUp, int id) {
//		list.forEach(b->{
//			if(b.getId()==id) {
//				b.setName(bookUp.getName());
//				b.setAuthor(bookUp.getAuthor());
//			}
//		});
		bookUp.setId(id);
		this.bookRepository.save(bookUp);
		
	}

}
