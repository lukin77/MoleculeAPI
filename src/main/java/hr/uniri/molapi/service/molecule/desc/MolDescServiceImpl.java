package hr.uniri.molapi.service.molecule.desc;

import hr.uniri.molapi.model.Mol;
import hr.uniri.molapi.repository.molecule.desc.MolDescRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MolDescServiceImpl implements MolDescService {

    private final MolDescRepository molDescRepository;

    @Autowired
    public MolDescServiceImpl(MolDescRepository molDescRepository) {
        this.molDescRepository = molDescRepository;
    }

    @Override
    public Double molAmw(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molAmw);
    }

    @Override
    public Double molExactMw(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molExactMw);
    }

    @Override
    public Double molLogP(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molLogP);
    }

    @Override
    public Double molTpsa(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molTpsa);
    }

    @Override
    public Double molLabuteAsa(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molLabuteAsa);
    }

    @Override
    public Double molFractionCsp3(Mol mol) {
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
    public String molInchi(Mol mol) {
        return executeDescFunction(mol, molDescRepository::molInchi);
    }

    @Override
    public String molInchikey(Mol mol) {
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

    private Double executeDescFunction(Mol mol, GivenMolReturnDouble function) {
        return function.apply(mol);
    }

    private Integer executeDescFunction(Mol mol, GivenMolReturnInteger function) {
        return function.apply(mol);
    }

    private String executeDescFunction(Mol mol, GivenMolReturnString function) {
        return function.apply(mol);
    }
}


@FunctionalInterface
interface GivenMolReturnDouble {
    Double apply(Mol mol);
}

@FunctionalInterface
interface GivenMolReturnInteger {
    Integer apply(Mol mol);
}

@FunctionalInterface
interface GivenMolReturnString {
    String apply(Mol mol);
}
