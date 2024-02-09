package hr.uniri.molapi.repository.molecule.desc;

import hr.uniri.molapi.model.Mol;

public interface MolDescRepository {
    Double molAmw(Mol mol);

    Double molExactMw(Mol mol);

    Double molLogP(Mol mol);

    Double molTpsa(Mol mol);

    Double molLabuteAsa(Mol mol);

    Double molFractionCsp3(Mol mol);

    Integer molHba(Mol mol);

    Integer molHbd(Mol mol);

    Integer molNumAtoms(Mol mol);

    Integer molNumHeavyAtoms(Mol mol);

    Integer molNumRotatableBonds(Mol mol);

    Integer molNumHeteroatoms(Mol mol);

    Integer molNumRings(Mol mol);

    Integer molNumAromaticRings(Mol mol);

    Integer molNumAliphaticRings(Mol mol);

    Integer molNumSaturatedRings(Mol mol);

    Integer molNumAromaticHeterocycles(Mol mol);

    Integer molNumAliphaticHeterocycles(Mol mol);

    Integer molNumSaturatedHeterocycles(Mol mol);

    Integer molNumAromaticCarbocycles(Mol mol);

    Integer molNumAliphaticCarbocycles(Mol mol);

    Integer molNumSaturatedCarbocycles(Mol mol);

    Integer molNumSpiroAtoms(Mol mol);

    Integer molNumBridgeheadAtoms(Mol mol);

    String molInchi(Mol mol);

    String molInchikey(Mol mol);
}
