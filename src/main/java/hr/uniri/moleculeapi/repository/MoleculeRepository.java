package hr.uniri.moleculeapi.repository;

import hr.uniri.moleculeapi.model.Molecule;

import java.util.List;

public interface MoleculeRepository {

    Molecule save (Molecule molecule);

    List<Molecule> searchBySubstructure(Molecule smilesMol);
}
