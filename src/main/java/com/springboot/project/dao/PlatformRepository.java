package com.springboot.project.dao;

import com.springboot.project.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform,Integer> {
}
