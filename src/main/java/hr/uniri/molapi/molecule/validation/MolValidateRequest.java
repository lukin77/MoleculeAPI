package hr.uniri.molapi.molecule.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MolValidateRequest {
    String molecule;
    String validationMethod;
}
