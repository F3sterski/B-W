package com.meet.up.blackandwhite.repository;

import com.meet.up.blackandwhite.model.Keys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeysRepository extends JpaRepository<Keys, Long> {
}
