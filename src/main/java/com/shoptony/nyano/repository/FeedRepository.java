package com.shoptony.nyano.repository;

import com.shoptony.nyano.entity.feed.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
}
