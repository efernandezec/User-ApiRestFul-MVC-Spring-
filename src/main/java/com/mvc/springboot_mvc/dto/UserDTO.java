package com.mvc.springboot_mvc.dto;

import java.time.LocalDate;

import com.mvc.springboot_mvc.models.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String lastname;
    private Gender gender;
    private Integer age;
    private LocalDate datebirth;

    public UserDTO(String username, String lastname, Gender gender, Integer age, LocalDate datebirth) {
        this.username = username;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.datebirth = datebirth;
    }

    @Override
    public String toString() {
        return "UserDTO [username=" + username + ", lastname=" + lastname + ", gender=" + gender + ", age=" + age
                + ", datebirth=" + datebirth + "]";
    }

    
}
