package hr.uniri.molapi.service.molecule.mcs;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.repository.molecule.mcs.MolMcsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MolMcsServiceImpl implements MolMcsService {

    private final MolMcsRepository molMcsRepository;

    @Autowired
    public MolMcsServiceImpl(MolMcsRepository molMcsRepository) {
        this.molMcsRepository = molMcsRepository;
    }

    @Override
    public Double fmcs(List<Mol> mols) {
        return molMcsRepository.fmcs(mols);
    }

    @Override
    public Double fmcsSmiles(String mols, String json) {
        return molMcsRepository.fmcsSmiles(mols, json);
    }
}
