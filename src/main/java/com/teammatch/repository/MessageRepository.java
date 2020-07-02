package com.teammatch.repository;

import com.teammatch.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findByChatId(Long chatId, Pageable pageable);
    Optional<Message> findByIdAndChatId(Long id, Long chatId);
}
