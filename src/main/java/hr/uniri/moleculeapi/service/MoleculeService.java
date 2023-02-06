package hr.uniri.moleculeapi.service;

import hr.uniri.moleculeapi.model.Molecule;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MoleculeService {
    Optional<List<Molecule>> findAll();

    Optional<Molecule> findMoleculeById(Integer id);

    ResponseEntity<Molecule> deleteMoleculeById(Integer id);

    Optional<Molecule> save(Molecule molecule);

    Optional<List<Molecule>> substructureSearch(Molecule smilesMol);
}
