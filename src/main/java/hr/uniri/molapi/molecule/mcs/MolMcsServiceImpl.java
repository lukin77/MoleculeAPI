package hr.uniri.molapi.molecule.mcs;

import hr.uniri.molapi.model.Mol;
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
    public String fmcs(List<Mol> mols) {
        // for each mol in mols add them to sting
        String molovi = mols.stream().map(Mol::getSmiles).reduce("", (s1, s2) -> s1 + " " + s2);
        return molMcsRepository.fmcs(molovi);
    }

    @Override
    public String fmcsSmiles(String mols, String json) {
        return molMcsRepository.fmcsSmiles(mols, json);
    }
}
