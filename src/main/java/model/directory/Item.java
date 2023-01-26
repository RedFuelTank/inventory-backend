package model.directory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import model.user.User;

@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "directoryId")
    private Long directoryId;

    @Column(name = "name")
    @NonNull
    private String name;

    @OneToOne
    @JoinColumn(name = "username")
    @NonNull
    private User user;
}
