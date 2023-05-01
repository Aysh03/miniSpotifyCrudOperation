package com.example.trackdata.repository;

import com.example.trackdata.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackRepository extends MongoRepository <Track,String>
{

}
