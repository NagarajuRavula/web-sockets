package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UrlDao;
import com.example.demo.model.Url;

@Service
public class UrlService {

	@Autowired
	private SocketHandler socketHandler;
	
	@Autowired
	private UrlDao urlDao;
	
	//private static final String USER_EDITING="is Editing";
	
	public boolean handleMessage(Url url) throws IOException {

		List<Url> dbUrl = urlDao.getUrlByUrlUsername(url.getUrlUsername());
		if(dbUrl==null || dbUrl.isEmpty())
			return false;
		else
			return true;
	}

	public void saveUrl(Url url) {
		urlDao.saveUrl(url);
	}
	
	public void deleteUrl(String socketId) {
		urlDao.deleteUrl(socketId);
	}
	
}
