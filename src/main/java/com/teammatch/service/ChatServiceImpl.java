package com.teammatch.service;

import com.teammatch.exception.ResourceNotFoundException;
import com.teammatch.model.Chat;
import com.teammatch.repository.ChatRepository;
import com.teammatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Page<Chat> getAllChats(Pageable pageable) {
        return chatRepository.findAll(pageable);
    }

    @Override
    public Page<Chat> getAllChatsByPlayerId(Long playerId, Pageable pageable) {
        return playerRepository.findById(playerId).map(player -> {
            List<Chat> chats = player.getChats();
            int chatsCount = chats.size();
            return new PageImpl<>(chats, pageable, chatsCount);
        })
                .orElseThrow(() -> new ResourceNotFoundException("Player", "Id", playerId));
    }

    @Override
    public Chat getChatById(Long chatId) {
        return chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat", "Id", chatId));
    }

    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public ResponseEntity<?> deleteChat(Long chatId) {
        return chatRepository.findById(chatId).map(chat -> {
            chatRepository.delete(chat);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Chat", "Id", chatId));
    }
}
