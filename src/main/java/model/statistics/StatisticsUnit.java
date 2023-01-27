package model.statistics;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import model.user.User;

@Entity
@Getter
@Setter
@Table(name = "Statistics")
public class StatisticsUnit {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "startDate")
    private Long startDate;

    @Column(name = "endDate")
    private Long endDate;

}
