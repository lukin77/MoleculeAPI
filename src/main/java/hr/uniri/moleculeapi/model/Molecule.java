package hr.uniri.moleculeapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mols", schema = "public")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Molecule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "molecules_generator")
    @SequenceGenerator(name = "molecules_generator", sequenceName = "mol_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "m")
    private String structure;
}
