package com.blackcode.project04.repository;

import com.blackcode.project04.entity.Hobie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobieRepository extends JpaRepository<Hobie, Long> {
}
