package hr.uniri.molapi.repository;

import hr.uniri.molapi.model.Mol;

import java.util.List;

public interface MolRepository {

    Mol save(Mol Mol);

    List<Mol> searchBySubstructure(Mol smilesMol);
}
