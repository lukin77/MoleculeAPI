package hr.uniri.molapi.service.molecule.substructureSearch;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface MolSubSearchService {
    List<Mol> retrieveSubstructures(Mol mol);

    List<Mol> retrieveAllMolsWhichContainGivenSubstructure(Mol mol);

    Boolean compareIfTwoMolsAreEqual(List<Mol> mols);
}
