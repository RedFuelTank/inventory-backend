package model.directory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.user.User;

@Entity
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
    @NonNull
    private User user;

    @Column(name = "name")
    @NonNull
    private String name;
}
