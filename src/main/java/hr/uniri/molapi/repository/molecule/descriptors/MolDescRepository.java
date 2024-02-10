package hr.uniri.molapi.repository.molecule.descriptors;

import hr.uniri.molapi.model.Mol;

public interface MolDescRepository {
    Float molAmw(Mol mol);

    Float molExactMw(Mol mol);

    Float molLogP(Mol mol);

    Float molTpsa(Mol mol);

    Float molLabuteAsa(Mol mol);

    Float molFractionCsp3(Mol mol);

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

    Integer molInchi(Mol mol);

    Integer molInchikey(Mol mol);
}
