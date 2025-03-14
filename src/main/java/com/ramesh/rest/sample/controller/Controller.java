package com.ramesh.rest.sample.controller;

import com.ramesh.rest.sample.dto.MessageDTO;
import com.ramesh.rest.sample.entity.MessageEntity;
import com.ramesh.rest.sample.repository.Repository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

//    @GetMapping("/")
//    public String getRoot(){
//        return "App launched";
//    }


    @Autowired
    private Repository repository;

    @GetMapping("/messagelist")
    public List<MessageEntity> MessageEntitys(@RequestParam Optional<Boolean> completed) {
        return completed.map(c -> this.repository.findAllByCompleted(c))
                .orElseGet(() -> this.repository.findAll());
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<MessageEntity> getMessageEntity(@PathVariable Long id) {
        return this.repository.findById(id)
                .map(MessageEntity -> ResponseEntity.ok().body(MessageEntity))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/messages")
    public ResponseEntity<Object> addTodo(@Valid @RequestBody MessageDTO dto) {
        this.repository.save(new MessageEntity(null, dto.getMessage(), false));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Object> updateTodo(@PathVariable Long id, @Valid @RequestBody MessageDTO dto) {
        return this.repository.findById(id)
                .map(messageEntity -> {
                    messageEntity.setMessage(dto.getMessage());
                    this.repository.save(messageEntity);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/message/{id}/mark_completed")
    public ResponseEntity<Object> markCompleted(@PathVariable Long id) {
        return this.repository.findById(id)
                .map(todo -> {
                    todo.setCompleted(true);
                    this.repository.save(todo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/message/{id}/mark_incomplete")
    public ResponseEntity<Object> markIncomplete(@PathVariable Long id) {
        return this.repository.findById(id)
                .map(todo -> {
                    todo.setCompleted(false);
                    this.repository.save(todo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return this.repository.findById(id)
                .map(todo -> {
                    this.repository.delete(todo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
