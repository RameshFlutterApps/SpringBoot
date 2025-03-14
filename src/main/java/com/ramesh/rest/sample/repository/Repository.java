package com.ramesh.rest.sample.repository;

import com.ramesh.rest.sample.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository  extends JpaRepository<MessageEntity,Long> {
}
