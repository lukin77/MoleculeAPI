package hr.uniri.molapi.repository.molecule.substructureSearch;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface MolSubSearchRepository {
    List<Mol> retrieveSubstructures(Mol mol);

    List<Mol> retrieveAllMolsWhichContainGivenSubstructure(Mol mol);

    Boolean compareIfTwoMolsAreEqual(String smiles1, String smiles2);
}
