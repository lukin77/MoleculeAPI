package hr.uniri.moleculeapi.service;

import hr.uniri.moleculeapi.model.Molecule;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MoleculeService {
    List<Molecule> findAll();

    ResponseEntity<Molecule> findMoleculeById(Integer id);

    ResponseEntity<Molecule> deleteMoleculeById(Integer id);

    Optional<Molecule> save(Molecule molecule);
}
