package hr.uniri.molapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mols", schema = "public")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Mol {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mols_generator")
    @SequenceGenerator(name = "mols_generator", sequenceName = "mol_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "m")
    private String structure;

    public Mol(String structure) {
        this.structure = structure;
    }
}
