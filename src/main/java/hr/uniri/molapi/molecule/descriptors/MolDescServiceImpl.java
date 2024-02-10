package hr.uniri.molapi.molecule.descriptors;

import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hr.uniri.molapi.utils.ExecuteMethod.execute;

@Service
public class MolDescServiceImpl implements MolDescService {

    private final MolDescRepository molDescRepository;

    @Autowired
    public MolDescServiceImpl(MolDescRepository molDescRepository) {
        this.molDescRepository = molDescRepository;
    }

    @Override
    public Float molAmw(Mol mol) {
        return execute(mol, molDescRepository::molAmw);
    }

    @Override
    public Float molExactMw(Mol mol) {
        return execute(mol, molDescRepository::molExactMw);
    }

    @Override
    public Float molLogP(Mol mol) {
        return execute(mol, molDescRepository::molLogP);
    }

    @Override
    public Float molTpsa(Mol mol) {
        return execute(mol, molDescRepository::molTpsa);
    }

    @Override
    public Float molLabuteAsa(Mol mol) {
        return execute(mol, molDescRepository::molLabuteAsa);
    }

    @Override
    public Float molFractionCsp3(Mol mol) {
        return execute(mol, molDescRepository::molFractionCsp3);
    }

    @Override
    public Integer molHba(Mol mol) {
        return execute(mol, molDescRepository::molHba);
    }

    @Override
    public Integer molHbd(Mol mol) {
        return execute(mol, molDescRepository::molHbd);
    }

    @Override
    public Integer molNumAtoms(Mol mol) {
        return execute(mol, molDescRepository::molNumAtoms);
    }

    @Override
    public Integer molNumHeavyAtoms(Mol mol) {
        return execute(mol, molDescRepository::molNumHeavyAtoms);
    }

    @Override
    public Integer molNumRotatableBonds(Mol mol) {
        return execute(mol, molDescRepository::molNumRotatableBonds);
    }

    @Override
    public Integer molNumHeteroatoms(Mol mol) {
        return execute(mol, molDescRepository::molNumHeteroatoms);
    }

    @Override
    public Integer molNumRings(Mol mol) {
        return execute(mol, molDescRepository::molNumRings);
    }

    @Override
    public Integer molNumAromaticRings(Mol mol) {
        return execute(mol, molDescRepository::molNumAromaticRings);
    }

    @Override
    public Integer molNumAliphaticRings(Mol mol) {
        return execute(mol, molDescRepository::molNumAliphaticRings);
    }

    @Override
    public Integer molNumSaturatedRings(Mol mol) {
        return execute(mol, molDescRepository::molNumSaturatedRings);
    }

    @Override
    public Integer molNumAromaticHeterocycles(Mol mol) {
        return execute(mol, molDescRepository::molNumAromaticHeterocycles);
    }

    @Override
    public Integer molNumAliphaticHeterocycles(Mol mol) {
        return execute(mol, molDescRepository::molNumAliphaticHeterocycles);
    }

    @Override
    public Integer molNumSaturatedHeterocycles(Mol mol) {
        return execute(mol, molDescRepository::molNumSaturatedHeterocycles);
    }

    @Override
    public Integer molNumAromaticCarbocycles(Mol mol) {
        return execute(mol, molDescRepository::molNumAromaticCarbocycles);
    }

    @Override
    public Integer molNumAliphaticCarbocycles(Mol mol) {
        return execute(mol, molDescRepository::molNumAliphaticCarbocycles);
    }

    @Override
    public Integer molNumSaturatedCarbocycles(Mol mol) {
        return execute(mol, molDescRepository::molNumSaturatedCarbocycles);
    }

    @Override
    public Integer molNumSpiroAtoms(Mol mol) {
        return execute(mol, molDescRepository::molNumSpiroAtoms);
    }

    @Override
    public Integer molNumBridgeheadAtoms(Mol mol) {
        return execute(mol, molDescRepository::molNumBridgeheadAtoms);
    }

    @Override
    public Integer molInchi(Mol mol) {
        return execute(mol, molDescRepository::molInchi);
    }

    @Override
    public Integer molInchikey(Mol mol) {
        return execute(mol, molDescRepository::molInchikey);
    }

    @Override
    public String molFormula(Mol mol, Boolean bool1, Boolean bool2) {
        // TODO: implement
        return null;
    }

    @Override
    public String molNmHash(Mol mol, String hashType) {
        // TODO: implement
        return null;
    }
}
