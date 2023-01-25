package model.directory;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import liquibase.ui.UIService;
import lombok.Getter;
import lombok.Setter;
import model.user.User;

@Entity
@Transactional
@Setter
@Getter
@Table(name = "directory")
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "upperId")
    private Long upperId;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "name")
    private String name;
}
