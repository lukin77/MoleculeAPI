package hr.uniri.molapi.molecule.mcs;

import hr.uniri.molapi.model.Mol;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MolMcsRepositoryImpl implements MolMcsRepository {
    @Override
    public Double fmcs(List<Mol> mols) {
        return null;
    }

    @Override
    public Double fmcsSmiles(String mols, String json) {
        return null;
    }
}
