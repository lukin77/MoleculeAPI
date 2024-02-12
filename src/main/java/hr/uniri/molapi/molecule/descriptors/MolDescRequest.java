package hr.uniri.molapi.molecule.descriptors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MolDescRequest {
    String molecule;
    String descriptor;
}
