package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String urlUsername;
	private int permissionType;
	private String username;
	private String socketId;
	
	private String editedBy;
	
	public Url() {

	}
	public Url(String urlUsername, int permissionType, String username, String socketId) {
		super();
		this.urlUsername = urlUsername;
		this.permissionType = permissionType;
		this.username = username;
		this.socketId = socketId;
	}


	public String getUrlUsername() {
		return urlUsername;
	}
	public void setUrlUsername(String urlUsername) {
		this.urlUsername = urlUsername;
	}
	public int getPermissionType() {
		return permissionType;
	}
	public void setPermissionType(int permissionType) {
		this.permissionType = permissionType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSocketId() {
		return socketId;
	}
	public void setSocketId(String socketId) {
		this.socketId = socketId;
	}
	public String getEditedBy() {
		return editedBy;
	}
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}
	@Override
	public String toString() {
		return "Url [id=" + id + ", urlUsername=" + urlUsername + ", permissionType=" + permissionType + ", username="
				+ username + ", socketId=" + socketId + "]";
	}	
}
