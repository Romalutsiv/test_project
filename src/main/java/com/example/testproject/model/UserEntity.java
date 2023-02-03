package com.example.testproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    @NotNull(message = "Id cannot be null!")
    private Long id;
    @Column(name = "firstname")
    @NotNull(message = "Firstname cannot be null!")
    private String firstname;
    @Column(name = "lastname")
    @NotNull(message = "Lastname cannot be null!")
    private String lastname;
    @Column(name = "birthday")
    @NotNull(message = "Birthday cannot be null!")
    private LocalDate birthday;
}
