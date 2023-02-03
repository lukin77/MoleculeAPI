package hr.uniri.moleculeapi.service;

import hr.uniri.moleculeapi.model.Molecule;
import hr.uniri.moleculeapi.repository.MoleculeJpaRepository;
import hr.uniri.moleculeapi.repository.MoleculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoleculeServiceImpl implements MoleculeService {

    private final MoleculeJpaRepository moleculeJpaRepository;
    private final MoleculeRepository moleculeRepository;

    @Autowired
    public MoleculeServiceImpl(MoleculeJpaRepository moleculeJpaRepository, MoleculeRepository moleculeRepository) {
        this.moleculeJpaRepository = moleculeJpaRepository;
        this.moleculeRepository = moleculeRepository;
    }

    @Override
    public List<Molecule> findAll() {
        return moleculeJpaRepository.findAll();
    }

    @Override
    public ResponseEntity<Molecule> findMoleculeById(Integer id) {
        Optional<Molecule> optionalMolecule = moleculeJpaRepository.findById(id);
        return optionalMolecule.map(Molecule -> ResponseEntity.ok().body(Molecule)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Molecule> deleteMoleculeById(Integer id) {
        if (findMoleculeById(id).getBody() != null) {
            moleculeJpaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public Optional<Molecule> save(Molecule molecule) {
        return moleculeRepository.save(molecule);
    }

    @Override
    public ResponseEntity<List<Molecule>> substructureSearch(Molecule smilesMol) {
//        Optional<List<Molecule>> moleculeList = moleculeJpaRepository.searchMoleculesByStructureContainingNative(smilesMol);

        Optional<List<Molecule>> moleculeList = moleculeRepository.searchBySubstructure(smilesMol);
        return moleculeList.map(molecules -> ResponseEntity.ok().body(molecules)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
}
