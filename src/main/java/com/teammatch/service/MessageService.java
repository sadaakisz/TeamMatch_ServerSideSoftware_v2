package com.teammatch.service;

import com.teammatch.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageService {
    Page<Message> getAllMessagesByChatId(Long chatId, Pageable pageable);
    Message getChatByIdAndChatId(Long chatId, Long messageId);

    Message createMessage(Long chatId,Message message);
    Message updateMessage(Long chatId, Long messageId, Message messageDetails);
    ResponseEntity<?> deleteMessage(Long chatId, Long messageId);
    List<Message> getAllMessages();
}
