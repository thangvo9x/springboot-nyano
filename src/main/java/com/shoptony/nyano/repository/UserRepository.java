package com.shoptony.nyano.repository;


import com.shoptony.nyano.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


// Annotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // find userName and userEmail

    List<UserEntity> findByUserNameOrUserEmail(String userName, String userEmail);

    UserEntity findByUserName(String userName);

    UserEntity findByUserEmail(String userEmail);


    /*
    * WHERE userName LIKE ?%
    * */

    List<UserEntity> findByUserNameStartingWith(String userName);

    /*
    * GET total users
    * */
    @Query(value = "SELECT COUNT(id) from java_user", nativeQuery = true)
    long getTotalUser();
}
