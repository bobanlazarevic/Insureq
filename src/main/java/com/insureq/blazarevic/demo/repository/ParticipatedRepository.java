package com.insureq.blazarevic.demo.repository;

import com.insureq.blazarevic.demo.model.Participated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipatedRepository extends JpaRepository<Participated, Long> {
}
