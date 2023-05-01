package com.example.trackdata.service;

import com.example.trackdata.model.Track;
import com.example.trackdata.model.UserDatas;

import java.util.List;

public interface UserDataService
{

    public abstract UserDatas addUser(UserDatas user);

    public abstract List<UserDatas> getAllUsers();

    public abstract UserDatas getUserDetails(String emailId);

    public abstract UserDatas addTrack(String emailId, Track track);



    public abstract boolean deleteTrackByUserFromList(Track track,String emailId);




}
