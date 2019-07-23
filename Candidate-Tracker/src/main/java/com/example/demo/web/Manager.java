package com.example.demo.web;

public class Manager {
private int childId;
private int parentId;
public Manager(int childId, int parentId) {
	super();
	this.childId = childId;
	this.parentId = parentId;
}
@Override
public String toString() {
	return "Manager [childId=" + childId + ", parentId=" + parentId + "]";
}
public int getChildId() {
	return childId;
}
public void setChildId(int childId) {
	this.childId = childId;
}
public int getParentId() {
	return parentId;
}
public void setParentId(int parentId) {
	this.parentId = parentId;
}

}
