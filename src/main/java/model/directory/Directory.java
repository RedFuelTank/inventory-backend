package model.directory;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;
}
