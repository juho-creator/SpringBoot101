package me.juhokim.SpringBootApplication;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Dream {
    @Id
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="dream", nullable = false)
    private String dream;
}
