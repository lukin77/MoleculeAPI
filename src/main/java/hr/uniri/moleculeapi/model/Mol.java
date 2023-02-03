package hr.uniri.moleculeapi.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Mol {
    public Mol(String m) {
        this.m = m;
    }

    private String m;
}
