package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.demo.model.Url;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SocketHandler extends TextWebSocketHandler {

	@Autowired
	private UrlService urlService;

	private WebSocketSession session;


	@Override

	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// The WebSocket has been closed
		System.out.println("connection is closed");
		urlService.deleteUrl(session.getId());
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		this.session = session;

		// The WebSocket has been opened
		// I might save this session object so that I can send messages to it outside of
		// this method
		// Let's send the first message
		// session.sendMessage(new TextMessage("You are now connected to the server.
		// This is the first message."));
		System.out.println("connection established;;;;");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
		System.out.println("Message received: " + textMessage.getPayload());
		String jsonObj = textMessage.getPayload();
		ObjectMapper mapper = new ObjectMapper();
		Url url = mapper.readValue(jsonObj, Url.class);
		url.setSocketId(session.getId());

		 boolean isPresent = urlService.handleMessage(url);
		 if(isPresent) {
			 url.setPermissionType(0);
			 //url.setEditedBy(getEditedUrlUser(url.getUrlUsername()));
		 }
		 else {
			 url.setPermissionType(1);
		 }
		 String objToJson = mapper.writeValueAsString(url);
		 session.sendMessage(new TextMessage(objToJson));
		 urlService.saveUrl(url);
	}

	public void sendMessage(Url url) throws IOException {
		session.sendMessage(new TextMessage(url.toString()));
	}
}
