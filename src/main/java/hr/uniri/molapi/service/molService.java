package hr.uniri.molapi.service;

import hr.uniri.molapi.model.Mol;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface molService {
    Optional<List<Mol>> findAll();

    Optional<Mol> findMolById(Integer id);

    ResponseEntity<Mol> deleteMolById(Integer id);

    Optional<Mol> save(Mol Mol);

    Optional<List<Mol>> substructureSearch(Mol Mol);
}
