package hr.uniri.molapi.molecule.substructureOperations;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface MolSubOpService {
    Boolean substruct(List<Mol> mols);

    Integer substructCount(List<Mol> mols, Boolean uniquified);

    Mol molAdjustQueryProperties(Mol mol, String properties);
}
