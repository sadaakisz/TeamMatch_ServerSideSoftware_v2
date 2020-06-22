package com.teammatch.service;

import com.teammatch.model.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ChatService {
    Page<Chat> getAllChats(Pageable pageable);
    Page<Chat> getAllChatsByPlayerId(Long playerId, Pageable pageable);

    Chat getChatById(Long chatId);
    Chat createChat(Chat chat);
    ResponseEntity<?> deleteChat(Long chatId);
}
