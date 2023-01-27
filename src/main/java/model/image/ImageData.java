package model.image;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import model.directory.Item;

@Entity
@Getter
@Setter
@Table(name = "Images")
public class ImageData {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @Lob
    @Column(name = "itemPicture")
    private byte[] itemPicture;

}
