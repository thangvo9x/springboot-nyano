package com.shoptony.nyano;

import com.shoptony.nyano.entity.feed.FeedEntity;
import com.shoptony.nyano.entity.user.UserEntity;
import com.shoptony.nyano.repository.FeedRepository;
import com.shoptony.nyano.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserFeedTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;


    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTest(){
         // 1 - New User
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserEmail("thangvo5969@gmail.com");
        user.setUserName("Thang Vo");
        user.setFeedList(List.of(feed));

        feed.setTitle(" Feed 01");
        feed.setDescription(" This is Feed 01 Desc");
        feed.setUser(user);

        userRepository.save(user);
        feedRepository.save(feed);
    }

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTwo(){
        // 1 - New User
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserEmail("thangvo2@gmail.com");
        user.setUserName("Thang Vo 2");
        user.setFeedList(List.of(feed));

        feed.setTitle(" Feed 02");
        feed.setDescription(" This is Feed 02 Desc");
        feed.setUser(user);

        userRepository.save(user);
//        feedRepository.save(feed);
    }

    @Test
    @Transactional
    void selectOneToMany() {
        UserEntity user = userRepository.findById(2L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeedList());


    }

}
