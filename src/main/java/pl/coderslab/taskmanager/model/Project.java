package pl.coderslab.taskmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="name")
    @Size(min = 2, max = 20, message = "{validation.constraints.Size.message}")
    private String name;

    @NotBlank
    @Column(name="description")
    @Size(min = 2, max = 100, message = "{validation.constraints.Size.message}")
    private String description;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;


}
