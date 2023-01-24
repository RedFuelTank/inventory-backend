package model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import model.directory.Directory;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "credit")
    private Double credit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rootDirectoryId")
    private Directory rootDirectory;
}
