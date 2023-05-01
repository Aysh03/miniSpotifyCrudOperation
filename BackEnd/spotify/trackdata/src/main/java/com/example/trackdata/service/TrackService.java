package com.example.trackdata.service;

import com.example.trackdata.model.Track;

import java.util.List;

public interface TrackService
{
    public abstract List<Track> getAlltracks();

    public abstract Track addTrack(Track track);

    public abstract  Track getTrackById(String trackId);

    public abstract boolean deleteTrack(String trackId);

    public abstract Track updateTrack (Track track);


}
