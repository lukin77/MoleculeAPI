package hr.uniri.moleculeapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mols", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class Molecule {

    public Molecule(Integer id, String mol) {
        this.id = id;
        this.mol = mol;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "m")
    private String mol;

}
