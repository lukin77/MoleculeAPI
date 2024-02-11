package hr.uniri.molapi.molecule.descriptors;

import hr.uniri.molapi.model.Mol;

public interface MolDescRepository {
    Float molAmw(Mol mol);

    Float molExactMw(Mol mol);

    Float molLogP(Mol mol);

    Float molTpsa(Mol mol);

    Float molLabuteAsa(Mol mol);

    Float molFractionCsp3(Mol mol);

    Float molHba(Mol mol);

    Float molHbd(Mol mol);

    Float molNumAtoms(Mol mol);

    Float molNumHeavyAtoms(Mol mol);

    Float molNumRotatableBonds(Mol mol);

    Float molNumHeteroatoms(Mol mol);

    Float molNumRings(Mol mol);

    Float molNumAromaticRings(Mol mol);

    Float molNumAliphaticRings(Mol mol);

    Float molNumSaturatedRings(Mol mol);

    Float molNumAromaticHeterocycles(Mol mol);

    Float molNumAliphaticHeterocycles(Mol mol);

    Float molNumSaturatedHeterocycles(Mol mol);

    Float molNumAromaticCarbocycles(Mol mol);

    Float molNumAliphaticCarbocycles(Mol mol);

    Float molNumSaturatedCarbocycles(Mol mol);

    Float molNumSpiroAtoms(Mol mol);

    Float molNumBridgeheadAtoms(Mol mol);

    Float molInchi(Mol mol);

    Float molInchikey(Mol mol);

    Float molFormula(Mol mol);

    Float molNmHash(Mol mol);
}
