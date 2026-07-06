package com.shoptony.nyano.entity.user;

import com.shoptony.nyano.entity.feed.FeedEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@Entity
@Table(name = "java_user")
@DynamicInsert
@DynamicUpdate
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(255) ")
    private String userName;

    @Column(nullable = false, columnDefinition = "varchar(255) ")
    private String userEmail;

    // 1 user -> many feeds
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY) // lazy loaded
    @ToString.Exclude
    private List<FeedEntity> feedList;

    // one -> one

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccd_id")
    private CCCDEntity cccd;
}
