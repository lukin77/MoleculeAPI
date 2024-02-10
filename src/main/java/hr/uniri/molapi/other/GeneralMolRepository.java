package hr.uniri.molapi.other;

import hr.uniri.molapi.model.Mol;

public interface GeneralMolRepository {

    Mol save(Mol Mol);

    String rdkitVersion();

    String rdkitToolkitVersion();
}
