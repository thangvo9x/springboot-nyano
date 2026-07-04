package com.shoptony.nyano.entity.feed;

import com.shoptony.nyano.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "java_feed")
public class FeedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "feedId BIGINT not null auto_increment", nullable = false)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId", nullable = false) // foreign key
    private UserEntity user;
}
