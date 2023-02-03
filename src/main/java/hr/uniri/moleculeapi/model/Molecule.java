package hr.uniri.moleculeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mols", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Molecule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "molecules_generator")
    @SequenceGenerator(name = "molecules_generator", sequenceName = "mol_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "m")
    @Embedded
    private Mol mol;

    @Override
    public String toString() {
        return "Molecule{" +
                "id=" + id +
                ", mol=" + mol +
                '}';
    }
}
