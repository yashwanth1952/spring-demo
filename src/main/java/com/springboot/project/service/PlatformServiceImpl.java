package com.springboot.project.service;

import com.springboot.project.dao.PlatformRepository;
import com.springboot.project.entity.Platform;
import com.springboot.project.exception.MovieNameAlreadyExists;
import com.springboot.project.exception.PlatformNameAlreadyExists;
import com.springboot.project.exception.PlatformNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformServiceImpl implements PlatformService{

    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findall() {
        return platformRepository.findAll();
    }

    @Override
    public Platform findById(int theId) {
        Optional<Platform> result = platformRepository.findById(theId);

        Platform platform=null;
        if(result.isPresent()){
            platform=result.get();
        }
        else{
            throw new PlatformNotFoundException("Did not find platform with id = "+theId);
        }
        return platform;

    }

    @Override
    public Platform save(Platform thePlatform) {

        try{
            platformRepository.save(thePlatform);
        }catch (Exception exception){

            throw new PlatformNameAlreadyExists("The Platform Name "+thePlatform.getName()+" is already used ." +
                    "Please use New Platform Name");
        }
        return thePlatform;
    }

    @Override
    public void delete(int theId) {

        platformRepository.deleteById(theId);
    }
}
