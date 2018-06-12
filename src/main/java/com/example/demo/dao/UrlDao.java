package com.example.demo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Url;
import com.example.demo.repository.UrlRepo;

@Repository
public class UrlDao {

	@Autowired
	private UrlRepo urlRepo;

	public Set<Url> getUrls() {
		return (Set<Url>) urlRepo.findAll();
	}
	
	public List<Url> getUrlByUrlUsername(String urlUsername) {
		return urlRepo.findByurlUsername(urlUsername);
	}

	public void saveUrl(Url url) {
		Url dbUrl = urlRepo.findByUrlUsernameAndUsername(url.getUrlUsername(), url.getUsername());
		if(dbUrl==null)
			urlRepo.save(url);
	}
	
	public void deleteUrl(String socketId) {
		urlRepo.deleteBySocketId(socketId);
	}
}
