package com.springboot.project.service;

import com.springboot.project.entity.Platform;

import java.util.List;

public interface PlatformService {

    public List<Platform> findall();

    public Platform findById(int theId);

    public Platform save(Platform thePlatform);

    public void delete(int theId);
}
