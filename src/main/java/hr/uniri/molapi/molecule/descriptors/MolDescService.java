package hr.uniri.molapi.molecule.descriptors;

import hr.uniri.molapi.model.Mol;

public interface MolDescService {

    Float description(MolDescRequest molDescRequest);

    String molFormula(Mol mol, Boolean bool1, Boolean bool2);

    String molNmHash(Mol mol, String hashType);

}
