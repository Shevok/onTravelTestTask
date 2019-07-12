package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "name")
    private  String name;

    @Column(name = "description")
    private String description;

}
