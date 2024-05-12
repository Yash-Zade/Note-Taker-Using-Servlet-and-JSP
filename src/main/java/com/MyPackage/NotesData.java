package com.MyPackage;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NotesData {
	@Id
	private int id;
	private String title;
	@Column(length=10000)
	private String note;
	private Date date;
	public NotesData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotesData(String title, String note, Date date) {
		super();
		this.id= new Random().nextInt(1000);
		this.title = title;
		this.note = note;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
