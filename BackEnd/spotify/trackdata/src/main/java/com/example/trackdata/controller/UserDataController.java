package com.example.trackdata.controller;


import com.example.trackdata.model.Track;
import com.example.trackdata.model.UserDatas;
import com.example.trackdata.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
@CrossOrigin
@RestController
@RequestMapping("/track-app")
public class UserDataController
{

    @Autowired
    UserDataService userDataService;

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody UserDatas userDatas)
    {
        userDatas.setTracks(new ArrayList<Track>());
        return new ResponseEntity<>(userDataService.addUser(userDatas), HttpStatus.OK);
    }

    @GetMapping("/get-user-details")
    public ResponseEntity<?> getUserDetails(HttpServletRequest request)
    {
        String emailid=(String) request.getAttribute("current_user_emailid");
        return new ResponseEntity<>(userDataService.getUserDetails(emailid),HttpStatus.OK);
    }


    @PostMapping("/add-track-to-user")
    public ResponseEntity<?> addTrack(HttpServletRequest request,@RequestBody Track track)
    {
        String emailid =(String) request.getAttribute("current_user_emailid");
        System.out.println(emailid);

        return new ResponseEntity<>(userDataService.addTrack(emailid,track),HttpStatus.OK);
    }


    @DeleteMapping("/delete-track-by-user")
    public ResponseEntity <?> deleteTrackByUser(HttpServletRequest request,@RequestBody Track track)
    {
        String email=(String) request.getAttribute("current_user_emailid");
        return new ResponseEntity<>(userDataService.deleteTrackByUserFromList(track,email),HttpStatus.OK);
    }





}
