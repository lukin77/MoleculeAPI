package hr.uniri.molapi.molecule.io;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MolInputOutputRequest {
    Object molecule;
    String format;
}
