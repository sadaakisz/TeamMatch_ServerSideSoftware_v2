package com.teammatch.controller;

import com.teammatch.model.Chat;
import com.teammatch.resource.ChatResource;
import com.teammatch.resource.SaveChatResource;
import com.teammatch.service.ChatService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Chats", description = "Chats API")
public class ChatController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ChatService chatService;

    @GetMapping("/chats")
    @Operation(summary = "Get All Chats", description = "Get All Chats from TeamMatch", tags = { "chats" })
    public Page<ChatResource> getAllChats(Pageable pageable) {
        List<ChatResource> chats = chatService.getAllChats(pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int chatsCount = chats.size();
        return new PageImpl<>(chats, pageable, chatsCount);
    }

    @GetMapping("/chats/{id}")
    @Operation(summary = "Get Chat By Id", description = "Get Chat by specific Id", tags = { "chats" })
    public ChatResource getChatById(@PathVariable(name = "id") Long chatId) {
        return convertToResource(chatService.getChatById(chatId));
    }

    @GetMapping("/players/{playerId}/chats")
    @Operation(summary = "Get All Chats by Player", description = "Get All Chats by Player Id", tags = { "chats, player" })
    public Page<ChatResource> getAllChatsByPlayerId(@PathVariable(name = "playerId") Long playerId, Pageable pageable) {
        List<ChatResource> chats = chatService.getAllChatsByPlayerId(playerId, pageable).getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int chatCount = chats.size();
        return new PageImpl<>(chats, pageable, chatCount);
    }

    @PostMapping("/chats")
    @Operation(summary = "Create chat", description = "Create a new chat from a Player", tags = { "chats, player" })
    //TODO: Chat not related to a player.
    public ChatResource createChat(@Valid @RequestBody SaveChatResource resource) {
        return convertToResource(chatService.createChat(convertToEntity(resource)));
    }

    private Chat convertToEntity(SaveChatResource resource)
    {
        return  mapper.map(resource, Chat.class);
    }

    private ChatResource convertToResource(Chat entity)
    {
        return mapper.map(entity, ChatResource.class);
    }

}
