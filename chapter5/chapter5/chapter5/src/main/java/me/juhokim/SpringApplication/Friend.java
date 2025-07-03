package me.juhokim.SpringApplication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity

public class Friend {
    @Id
    @Column(name ="id", updatable = false)
    private long id;

    @Column(name="name", nullable = false)
    private String name;


}
