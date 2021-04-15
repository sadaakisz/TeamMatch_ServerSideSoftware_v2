package com.teammatch.controller;

import com.teammatch.model.Message;
import com.teammatch.resource.MessageResource;
import com.teammatch.resource.SaveMessageResource;
import com.teammatch.service.MessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Tag(name = "Messages", description = "Message API")
public class MessageController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/chats/{chatId}/messages")
    public Page<MessageResource> getAllChatsByUserId(
            @PathVariable(name = "chatId") Long chatId,
            Pageable pageable)
    {
        Page<Message> messagePage = messageService.getAllMessagesByChatId(chatId, pageable);
        List<MessageResource> resources = messagePage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/chats/{chatId}/messages/{messageId}")
    public MessageResource getMessageByIdAndChatId(@PathVariable(name = "chatId") Long chatId,
                                                     @PathVariable(name = "messageId") Long messageId){
        return convertToResource(messageService.getChatByIdAndChatId(chatId, messageId));
    }

    @PostMapping("/chats/{chatId}/messages")
    public MessageResource createMessage(@PathVariable(name = "chatId") Long chatId,
                                           @Valid @RequestBody SaveMessageResource resource){
        return convertToResource(messageService.createMessage(chatId, convertToEntity(resource)));
    }

    @PutMapping("/chats/{chatId}/messages/{messageId}")
    public MessageResource updateMessage(@PathVariable(name = "chatId") Long chatId,
                                           @PathVariable(name = "messageId") Long messageId,
                                           @Valid @RequestBody SaveMessageResource resource){
        return convertToResource(messageService.updateMessage(chatId, messageId, convertToEntity(resource)));
    }

    @DeleteMapping("/chats/{chatId}/messages/{messageId}")
    public ResponseEntity<?> deleteMessage(@PathVariable(name = "chatId") Long chatId,
                                            @PathVariable(name="messageId") Long messageId){
        return  messageService.deleteMessage(chatId, messageId);
    }

    private Message convertToEntity(SaveMessageResource resource) {
        return mapper.map(resource, Message.class);
    }

    private MessageResource convertToResource(Message entity) {
        return mapper.map(entity, MessageResource.class);
    }



}
