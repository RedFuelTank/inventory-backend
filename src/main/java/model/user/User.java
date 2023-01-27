package model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "credit")
    private double credit;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Authorities", joinColumns = @JoinColumn(name = "username"))
    @Column(name = "authority")
    private List<String> authorities;
}
