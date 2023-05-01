package com.example.trackdata.service;


import com.example.trackdata.model.Track;
import com.example.trackdata.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl  implements TrackService
{
    @Autowired
    TrackRepository trackRepository;


    @Override
    public List<Track> getAlltracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track addTrack(Track track) {
        return trackRepository.insert(track);
    }

    @Override
    public Track getTrackById(String trackId) {
        return trackRepository.findById(trackId).get();
    }

    @Override
    public boolean deleteTrack(String trackId) {
        trackRepository.deleteById(trackId);
        return false;
    }

    @Override
    public Track updateTrack(Track track) {
        return trackRepository.save(track);
    }
}
