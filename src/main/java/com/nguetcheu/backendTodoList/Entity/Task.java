package com.nguetcheu.backendTodoList.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)  // Important pour activer l'audit
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private boolean done;
    @CreatedDate
    @Column(updatable = false)
    private Date targetDate;
}
