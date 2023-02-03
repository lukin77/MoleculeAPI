package hr.uniri.moleculeapi.service;

import hr.uniri.moleculeapi.model.Molecule;
import hr.uniri.moleculeapi.repository.MoleculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoleculeServiceImpl implements MoleculeService {

    private final MoleculeRepository moleculeRepository;

    @Autowired
    public MoleculeServiceImpl(MoleculeRepository moleculeRepository) {
        this.moleculeRepository = moleculeRepository;
    }

    @Override
    public List<Molecule> findAll() {
        return moleculeRepository.findAll();
    }

    @Override
    public ResponseEntity<Molecule> findMoleculeById(Integer id) {
        Optional<Molecule> optionalMolecule = moleculeRepository.findById(id);
        return optionalMolecule.map(Molecule -> ResponseEntity.ok().body(Molecule)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Molecule> deleteMoleculeById(Integer id) {
        if (findMoleculeById(id).getBody() != null) {
            moleculeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public Optional<Molecule> save(Molecule molecule) {
        return Optional.of(moleculeRepository.save(molecule));
    }
}
