package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Url;


public interface UrlRepo  extends CrudRepository<Url, Integer>{

	public List<Url> findByurlUsername(String urlUsername);
	
	public void deleteBySocketId(String socketId);
	
	public Url findByUrlUsernameAndUsername(String urlUsername,String username);
}
