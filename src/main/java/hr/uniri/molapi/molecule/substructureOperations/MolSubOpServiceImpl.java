package hr.uniri.molapi.molecule.substructureOperations;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MolSubOpServiceImpl implements MolSubOpService {

    private final MolSubOpRepository molSubOpRepository;

    @Autowired
    public MolSubOpServiceImpl(MolSubOpRepository molSubOpRepository) {
        this.molSubOpRepository = molSubOpRepository;
    }

    @Override
    public Boolean substruct(List<Mol> mols) {
        if (mols == null || mols.size() != 2) {
            throw new IllegalArgumentException("List must contain exactly two Mol objects");
        }

        return molSubOpRepository.substruct(mols.get(0), mols.get(1));
    }

    @Override
    public Integer substructCount(List<Mol> mols, Boolean uniquified) {
        if (mols == null || mols.size() != 2) {
            throw new IllegalArgumentException("List must contain exactly two Mol objects");
        }

        return molSubOpRepository.substructCount(mols.get(0), mols.get(1), uniquified);
    }

    @Override
    public Mol molAdjustQueryProperties(Mol mol, String properties) {
        return molSubOpRepository.molAdjustQueryProperties(mol, properties);
    }
}
