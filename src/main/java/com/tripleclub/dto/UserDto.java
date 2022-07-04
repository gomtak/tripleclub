package com.tripleclub.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tripleclub.entity.Mileage;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class UserDto{

    private String userId;
    private String name;
    @JsonBackReference
    @JsonManagedReference
    private List<Mileage> mileageList;

    public void covertUserDto() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(this.mileageList);
//        System.out.println();
    }
}
