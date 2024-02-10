package hr.uniri.molapi.molecule.substructureOperations;

import hr.uniri.molapi.model.Mol;

public interface MolSubOpRepository {
    Boolean substruct(Mol mol, Mol mol1);

    Integer substructCount(Mol mol, Mol mol1, Boolean uniquified);

    Mol molAdjustQueryProperties(Mol mol, String properties);
}
