package hr.uniri.molapi.molecule.mcs;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface MolMcsRepository {
    String fmcs(String mols);

    String fmcsSmiles(String mols, String json);
}
