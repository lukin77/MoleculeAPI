package hr.uniri.molapi.repository.molecule.mcs;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface MolMcsRepository {
    Double fmcs(List<Mol> mols);

    Double fmcsSmiles(String mols, String json);
}
