package com.ramesh.rest.sample.repository;

import com.ramesh.rest.sample.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository  extends JpaRepository<MessageEntity,Long> {
    public List<MessageEntity> findAllByCompleted(Boolean completed);
}
