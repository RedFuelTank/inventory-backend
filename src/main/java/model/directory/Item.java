package model.directory;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import model.user.User;

@Entity
@Getter
@Setter
@Transactional
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "directoryId")
    private Long directoryId;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;
}
