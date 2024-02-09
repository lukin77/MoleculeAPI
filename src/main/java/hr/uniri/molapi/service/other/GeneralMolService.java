package hr.uniri.molapi.service.other;

import hr.uniri.molapi.model.Mol;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GeneralMolService {
    Optional<List<Mol>> findAll();

    Optional<Mol> findMolById(Integer id);

    ResponseEntity<Mol> deleteMolById(Integer id);

    Optional<Mol> save(Mol Mol);

    Optional<List<Mol>> substructureSearch(Mol Mol);

    String rdkitVersion();

    String rdkitToolkitVersion();
}
