package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_manager",schema="hr")
public class UserManager {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int parentId;
	private int childId;
	
	
	
	public UserManager(int id, int parentId, int childId) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.childId = childId;
	}
	public UserManager() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getChildId() {
		return childId;
	}
	public void setChildId(int childId) {
		this.childId = childId;
	}
	@Override
	public String toString() {
		return "UserManager [id=" + id + ", parentId=" + parentId + ", childId=" + childId + "]";
	}
	
	
}
