package hr.uniri.molapi.repository.molecule.condesc;

import hr.uniri.molapi.model.Mol;

public interface MolConDescRepository {

    Float molChi0v(Mol mol);

    Float molChi1v(Mol mol);

    Float molChi2v(Mol mol);

    Float molChi3v(Mol mol);

    Float molChi4v(Mol mol);

    Float molChi0n(Mol mol);

    Float molChi1n(Mol mol);

    Float molChi2n(Mol mol);

    Float molChi3n(Mol mol);

    Float molChi4n(Mol mol);

    Float molKappa1(Mol mol);

    Float molKappa2(Mol mol);

    Float molKappa3(Mol mol);

    Float molPhi(Mol mol);

    Float molHallkieralpha(Mol mol);
}
