package hr.uniri.moleculeapi.repository;

import hr.uniri.moleculeapi.model.Molecule;

import java.util.Optional;

public interface MoleculeRepository {

    Optional<Molecule> save (Molecule molecule);
}
