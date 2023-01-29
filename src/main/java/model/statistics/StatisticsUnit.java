package model.statistics;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import model.directory.Item;
import model.user.User;

import java.util.Date;

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

    @OneToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

}
