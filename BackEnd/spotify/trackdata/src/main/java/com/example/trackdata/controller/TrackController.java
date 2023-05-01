package com.example.trackdata.controller;


import com.example.trackdata.model.Track;
import com.example.trackdata.repository.TrackRepository;
import com.example.trackdata.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/track-app")
public class TrackController
{

    @Autowired
    private TrackService trackService;
    @Autowired


    @GetMapping("/get-all-tracks")
    public ResponseEntity<?> getAlltracks()
    {
        return new ResponseEntity<>(trackService.getAlltracks(), HttpStatus.OK);
    }


    @GetMapping("/get-track-by-id/{trackId}")
    public ResponseEntity<?> getTrackById (@PathVariable String productId)
    {
        return new ResponseEntity<>(trackService.getTrackById(productId),HttpStatus.OK);
    }

    @PostMapping("/admin/add-new-track")
    public ResponseEntity<?> addTrack(@RequestBody Track track)
    {
        return new ResponseEntity<>(trackService.addTrack(track),HttpStatus.OK);
    }


    @PutMapping("/admin/update-track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)
    {
        return new ResponseEntity<>(trackService.updateTrack(track),HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete-track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable String trackId)
    {
        return new ResponseEntity<>(trackService.deleteTrack(trackId),HttpStatus.OK);
    }

























}
