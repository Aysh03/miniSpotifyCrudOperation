package com.example.trackdata.service;


import com.example.trackdata.model.Track;
import com.example.trackdata.model.UserDatas;
import com.example.trackdata.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public UserDatas addUser(UserDatas user) {
        return userDataRepository.insert(user);
    }

    @Override
    public List<UserDatas> getAllUsers() {
        return userDataRepository.findAll();
    }

    @Override
    public UserDatas getUserDetails(String emailId) {
        return userDataRepository.findById(emailId).get();
    }

    @Override
    public UserDatas addTrack(String emailId, Track track) {
        if (userDataRepository.findById(emailId).isPresent()) {
            UserDatas user = userDataRepository.findById(emailId).get();
            user.getTracks().add(track);
            return userDataRepository.save(user);
        } else {
            return null;
        }


    }

    @Override
    public boolean deleteTrackByUserFromList(Track track, String emailId) {

        if (userDataRepository.findById(emailId).isPresent()) {
            UserDatas userDatas = userDataRepository.findById(emailId).get();
            userDatas.getTracks().remove(track);
            userDataRepository.save(userDatas);
        }
        return false;
    }

}
