package com.shoptony.nyano.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "java_cccd")
public class CCCDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numberCCCD;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id");
//    private UserEntity user;
}
