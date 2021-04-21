package com.training.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;


@Entity
public class Image {

	@Id
	@GeneratedValue
	int id;
	
	String name;
	long size;
	String path;
	
	
	String username;

	public String getName() {
		return name;
	}
	public Image() {}

	public Image(String name, long size, String path, String username) {
		super();
		this.name = name;
		this.size = size;
		this.path = path;
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
	public float getSize() {
		return  (float)((this.size)/1024.0/1000.0);
	}

	public void setSize(int size) {
		this.size = size;
	}
	public String getPath() {
		return this.path;
	}
	
}
