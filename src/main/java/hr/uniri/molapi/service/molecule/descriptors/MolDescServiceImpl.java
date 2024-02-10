package hr.uniri.molapi.service.molecule.descriptors;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.repository.molecule.descriptors.MolDescRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MolDescServiceImpl implements MolDescService {

    private final MolDescRepository molDescRepository;

    @Autowired
    public MolDescServiceImpl(MolDescRepository molDescRepository) {
        this.molDescRepository = molDescRepository;
    }

    @Override
    public Float molAmw(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molAmw);
    }

    @Override
    public Float molExactMw(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molExactMw);
    }

    @Override
    public Float molLogP(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molLogP);
    }

    @Override
    public Float molTpsa(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molTpsa);
    }

    @Override
    public Float molLabuteAsa(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molLabuteAsa);
    }

    @Override
    public Float molFractionCsp3(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molFractionCsp3);
    }

    @Override
    public Integer molHba(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molHba);
    }

    @Override
    public Integer molHbd(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molHbd);
    }

    @Override
    public Integer molNumAtoms(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumAtoms);
    }

    @Override
    public Integer molNumHeavyAtoms(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumHeavyAtoms);
    }

    @Override
    public Integer molNumRotatableBonds(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumRotatableBonds);
    }

    @Override
    public Integer molNumHeteroatoms(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumHeteroatoms);
    }

    @Override
    public Integer molNumRings(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumRings);
    }

    @Override
    public Integer molNumAromaticRings(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumAromaticRings);
    }

    @Override
    public Integer molNumAliphaticRings(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumAliphaticRings);
    }

    @Override
    public Integer molNumSaturatedRings(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumSaturatedRings);
    }

    @Override
    public Integer molNumAromaticHeterocycles(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumAromaticHeterocycles);
    }

    @Override
    public Integer molNumAliphaticHeterocycles(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumAliphaticHeterocycles);
    }

    @Override
    public Integer molNumSaturatedHeterocycles(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumSaturatedHeterocycles);
    }

    @Override
    public Integer molNumAromaticCarbocycles(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumAromaticCarbocycles);
    }

    @Override
    public Integer molNumAliphaticCarbocycles(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumAliphaticCarbocycles);
    }

    @Override
    public Integer molNumSaturatedCarbocycles(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumSaturatedCarbocycles);
    }

    @Override
    public Integer molNumSpiroAtoms(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumSpiroAtoms);
    }

    @Override
    public Integer molNumBridgeheadAtoms(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molNumBridgeheadAtoms);
    }

    @Override
    public Integer molInchi(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molInchi);
    }

    @Override
    public Integer molInchikey(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molInchikey);
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

    private <T> T executeDescFunction(Mol mol, Function<Mol, T> function) {
        return function.apply(mol);
    }
}
