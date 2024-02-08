package hr.uniri.molapi.service.other;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.repository.MolJpaRepository;
import hr.uniri.molapi.repository.MolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MolServiceImpl implements MolService {

    private final MolJpaRepository molJpaRepository;
    private final MolRepository molRepository;

    @Autowired
    public MolServiceImpl(MolJpaRepository molJpaRepository, MolRepository molRepository) {
        this.molJpaRepository = molJpaRepository;
        this.molRepository = molRepository;
    }

    @Override
    public Optional<List<Mol>> findAll() {
        return Optional.of(molJpaRepository.findAll());
    }

    @Override
    public Optional<Mol> findMolById(Integer id) {
        return molJpaRepository.findById(id);
    }

    @Override
    public ResponseEntity<Mol> deleteMolById(Integer id) {
        if (findMolById(id).isPresent()) {
            molJpaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Optional<Mol> save(Mol Mol) {
        return Optional.ofNullable(molRepository.save(Mol));
    }

    @Override
    public Optional<List<Mol>> substructureSearch(Mol Mol) {
        return Optional.ofNullable(molRepository.searchBySubstructure(Mol));
    }
}
