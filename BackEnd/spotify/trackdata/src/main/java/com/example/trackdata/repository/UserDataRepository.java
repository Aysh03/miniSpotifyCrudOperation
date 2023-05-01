package com.example.trackdata.repository;

import com.example.trackdata.model.UserDatas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataRepository  extends MongoRepository <UserDatas,String> {
}
