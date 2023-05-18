package com.springboot.students.springboot_students_groups.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"id"})
@Entity
@ToString
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String fullName;

    @Column(name = "admissiondate")
    private LocalDate admissionDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Group group;

    public String getAdmissionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return admissionDate.format(formatter);
    }


}
