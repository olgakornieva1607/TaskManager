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
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="name")
    @Size(min = 2, max = 50, message = "{validation.constraints.Size.message}")
    private String name;

    @NotBlank
    @Column(name="description")
    @Size(min = 2, max = 200, message = "{validation.constraints.Size.message}")
    private String description;

    @Column(name="status")
    @Size(min = 2, max = 20, message = "{validation.constraints.Size.message}")
    private String status;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
