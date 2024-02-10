package hr.uniri.molapi.other;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralMolServiceImpl implements GeneralMolService {

    private final GeneralMolJpaRepository generalMolJpaRepository;
    private final GeneralMolRepository generalMolRepository;

    @Autowired
    public GeneralMolServiceImpl(GeneralMolJpaRepository generalMolJpaRepository, GeneralMolRepository generalMolRepository) {
        this.generalMolJpaRepository = generalMolJpaRepository;
        this.generalMolRepository = generalMolRepository;
    }

    @Override
    public Optional<List<Mol>> findAll() {
        return Optional.of(generalMolJpaRepository.findAll());
    }

    @Override
    public Optional<Mol> findMolById(Integer id) {
        return generalMolJpaRepository.findById(id);
    }

    @Override
    public ResponseEntity<Mol> deleteMolById(Integer id) {
        if (findMolById(id).isPresent()) {
            generalMolJpaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Optional<Mol> save(Mol Mol) {
        return Optional.ofNullable(generalMolRepository.save(Mol));
    }


    @Override
    public String rdkitVersion() {
        return generalMolRepository.rdkitVersion();
    }

    @Override
    public String rdkitToolkitVersion() {
        return generalMolRepository.rdkitToolkitVersion();
    }
}
