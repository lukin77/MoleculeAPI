package hr.uniri.moleculeapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mol {
    public Mol(String structure) {
        this.structure = structure;
    }

    private String structure;
}
