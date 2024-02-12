package hr.uniri.molapi.molecule.mcs;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface MolMcsService {
    String fmcs(List<Mol> mols);

    String fmcsSmiles(String mols, String json);
}
