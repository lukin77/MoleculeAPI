package hr.uniri.molapi.molecule.substructureSearch;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MolSubSearchServiceImpl implements MolSubSearchService {

    private final MolSubSearchRepository molSubSearchRepository;

    @Autowired
    public MolSubSearchServiceImpl(MolSubSearchRepository molSubSearchRepository) {
        this.molSubSearchRepository = molSubSearchRepository;
    }

    @Override
    public List<Mol> retrieveSubstructures(Mol mol) {
        return molSubSearchRepository.retrieveSubstructures(mol);
    }

    @Override
    public List<Mol> retrieveAllMolsWhichContainGivenSubstructure(Mol mol) {
        return molSubSearchRepository.retrieveAllMolsWhichContainGivenSubstructure(mol);
    }

    @Override
    public Boolean compareIfTwoMolsAreEqual(List<Mol> mols) {
        // extract mols from list
        String smiles1 = mols.get(0).getSmiles();
        String smiles2 = mols.get(1).getSmiles();

        return molSubSearchRepository.compareIfTwoMolsAreEqual(smiles1, smiles2);
    }
}
