package com.shoptony.nyano.repository;


import com.shoptony.nyano.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// Annotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // pageable
    Page<UserEntity> findByUserNameContaining(String userName, Pageable pageable);


    // find userName and userEmail

    List<UserEntity> findByUserNameOrUserEmail(String userName, String userEmail);

//    UserEntity findByUserName(String userName);

    UserEntity findByUserEmail(String userEmail);

    /*
    * Delete user by user email
    * */
    @Modifying
    @Transactional
    int deleteByUserEmail(String userEmail);


    /*
    * WHERE userName LIKE ?%
    * */

    List<UserEntity> findByUserNameStartingWith(String userName);

    /* native query
    * GET total users
    * */
    @Query(value = "SELECT COUNT(id) from java_user", nativeQuery = true)
    long getTotalUser();

    /* RAW JPQL
     * GET User By Id
     * */
    @Query(value = "SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> getUserEntityById(String userName, String userEmail);

    @Query(value = "SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail")
    List<UserEntity> getUserEntityByTwo(@Param("userName") String userName, @Param("userEmail") String userEmail);

    /*
     * UPDATE User By Id
     * */
    @Modifying
    @Transactional
    @Query(value = "UPDATE UserEntity u SET u.userEmail = :userName")
    int updateUserName(@Param("userName") String userName);


}
