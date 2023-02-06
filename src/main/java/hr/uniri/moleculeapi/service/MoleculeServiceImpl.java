package hr.uniri.moleculeapi.service;

import hr.uniri.moleculeapi.model.Molecule;
import hr.uniri.moleculeapi.repository.MoleculeJpaRepository;
import hr.uniri.moleculeapi.repository.MoleculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<List<Molecule>> findAll() {
        return Optional.ofNullable(moleculeJpaRepository.findAll());
    }

    @Override
    public Optional<Molecule> findMoleculeById(Integer id) {
        return moleculeJpaRepository.findById(id);
    }

    @Override
    public ResponseEntity<Molecule> deleteMoleculeById(Integer id) {
        if (findMoleculeById(id).isPresent()) {
            moleculeJpaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Optional<Molecule> save(Molecule molecule) {
        return Optional.ofNullable(moleculeRepository.save(molecule));
    }

    @Override
    public Optional<List<Molecule>> substructureSearch(Molecule molecule) {
        return Optional.ofNullable(moleculeRepository.searchBySubstructure(molecule));
    }
}
