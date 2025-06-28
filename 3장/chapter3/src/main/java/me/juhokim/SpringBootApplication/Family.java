package me.juhokim.SpringBootApplication;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // Default constructor (Required by JPA for entity instantiation and table creation)
@AllArgsConstructor // Constructor with parameters (id, name) for later use (not required by JPA, but useful in other cases)
@Getter // Getter methods for all fields (to access the values of the entity)
@Entity // Marks the class as a JPA entity to be mapped to a database table

public class Family {
    @Id // Marks the field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the 'id' value (commonly auto-increment in DB)
    @Column(name="id", updatable = false) // Maps the 'id' field to the 'id' column in the table and prevents it from being updated
    private Long id;

    @Column(name = "name", nullable= false) // Maps the 'name' field to the 'name' column in the table and ensures it cannot be null
    private String name;
}
