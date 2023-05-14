package pl.coderslab.taskmanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20, message = "{validation.constraints.Size.message}")
    @Column(name = "username", unique=true)
    private String userName;

    @NotBlank
    @Size(min = 2, max = 20, message = "{validation.constraints.Size.message}")
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name="users_projects")
    private Set<Project> projects = new HashSet<>();


}
