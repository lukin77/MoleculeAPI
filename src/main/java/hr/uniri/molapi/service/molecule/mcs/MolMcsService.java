package hr.uniri.molapi.service.molecule.mcs;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface MolMcsService {
    Double fmcs(List<Mol> mols);

    Double fmcsSmiles(String mols, String json);
}
