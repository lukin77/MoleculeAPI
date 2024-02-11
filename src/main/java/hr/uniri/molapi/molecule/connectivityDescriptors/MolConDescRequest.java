package hr.uniri.molapi.molecule.connectivityDescriptors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MolConDescRequest {
    private String smiles;
    private String connectivityDescriptor;
}
