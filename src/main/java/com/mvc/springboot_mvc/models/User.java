package com.mvc.springboot_mvc.models;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "datebirth")
    private LocalDate datebirth;

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", lastname=" + lastname + ", gender=" + gender + ", age="
                + age + ", datebirth=" + datebirth + "]";
    }
}


