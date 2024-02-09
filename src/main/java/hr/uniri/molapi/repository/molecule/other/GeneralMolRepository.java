package hr.uniri.molapi.repository.molecule.other;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface GeneralMolRepository {

    Mol save(Mol Mol);

    List<Mol> searchBySubstructure(Mol smilesMol);

    String rdkitVersion();

    String rdkitToolkitVersion();
}
