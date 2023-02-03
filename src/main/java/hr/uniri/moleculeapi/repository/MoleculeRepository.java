package hr.uniri.moleculeapi.repository;

import hr.uniri.moleculeapi.model.Molecule;

import java.util.List;
import java.util.Optional;

public interface MoleculeRepository {

    Optional<Molecule> save (Molecule molecule);

    Optional<List<Molecule>> searchBySubstructure(Molecule smilesMol);
}
