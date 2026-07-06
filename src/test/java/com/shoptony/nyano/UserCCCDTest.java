package com.shoptony.nyano;

import com.shoptony.nyano.entity.user.CCCDEntity;
import com.shoptony.nyano.entity.user.UserEntity;
import com.shoptony.nyano.repository.CCCDRepository;
import com.shoptony.nyano.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class UserCCCDTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CCCDRepository cccdRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToOneTest() {
        UserEntity user = new UserEntity();
        CCCDEntity cccd = new CCCDEntity();

        user.setUserEmail("thangvotest@gmail.com");
        user.setUserName("Thang Vo Test");

        cccd.setNumberCCCD("111122223333");

        user.setCccd(cccd);

        userRepository.save(user);

    }
}
