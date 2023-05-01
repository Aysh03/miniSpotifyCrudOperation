package com.example.trackdata.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserDatas
{
    @Id
    private String emailId;
    private String userName,address,mobileNo,age;
    private List<Track> tracks;
}
