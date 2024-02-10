package hr.uniri.molapi.service.molecule.condesc;

import hr.uniri.molapi.model.Mol;

public interface MolConDescService {
    Float molChiXv(Mol mol, int x);

    Float MolChiXn(Mol mol, int x);

    Float molKappaX(Mol mol, int x);

    Float molPhi(Mol mol);

    Float molHallkieralpha(Mol mol);
}
