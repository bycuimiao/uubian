package com.uubian.userbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uubian.userbase.domain.UserBase;
@Repository
public interface UseBaseRepository extends JpaRepository<UserBase, Long>{

}
