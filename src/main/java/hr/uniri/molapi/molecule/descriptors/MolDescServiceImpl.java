package hr.uniri.molapi.molecule.descriptors;

import hr.uniri.molapi.model.enums.Descriptor;
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
    public Float description(MolDescRequest molDescRequest) {
        Descriptor descriptor = Descriptor.valueOf(molDescRequest.getDescriptor());
        Mol mol = new Mol(molDescRequest.getSmiles());

        return switch (descriptor) {
            case mol_amw -> execute(mol, molDescRepository::molAmw);
            case mol_exactmw -> execute(mol, molDescRepository::molExactMw);
            case mol_logp -> execute(mol, molDescRepository::molLogP);
            case mol_tpsa -> execute(mol, molDescRepository::molTpsa);
            case mol_labuteasa -> execute(mol, molDescRepository::molLabuteAsa);
            case mol_fractioncsp3 -> execute(mol, molDescRepository::molFractionCsp3);
            case mol_hba -> execute(mol, molDescRepository::molHba);
            case mol_hbd -> execute(mol, molDescRepository::molHbd);
            case mol_numatoms -> execute(mol, molDescRepository::molNumAtoms);
            case mol_numheavyatoms -> execute(mol, molDescRepository::molNumHeavyAtoms);
            case mol_numrotatablebonds -> execute(mol, molDescRepository::molNumRotatableBonds);
            case mol_numheteroatoms -> execute(mol, molDescRepository::molNumHeteroatoms);
            case mol_numrings -> execute(mol, molDescRepository::molNumRings);
            case mol_numaromaticrings -> execute(mol, molDescRepository::molNumAromaticRings);
            case mol_numaliphaticrings -> execute(mol, molDescRepository::molNumAliphaticRings);
            case mol_numsaturatedrings -> execute(mol, molDescRepository::molNumSaturatedRings);
            case mol_numaromaticheterocycles -> execute(mol, molDescRepository::molNumAromaticHeterocycles);
            case mol_numaliphaticheterocycles -> execute(mol, molDescRepository::molNumAliphaticHeterocycles);
            case mol_numsaturatedheterocycles -> execute(mol, molDescRepository::molNumSaturatedHeterocycles);
            case mol_numaromaticcarbocycles -> execute(mol, molDescRepository::molNumAromaticCarbocycles);
            case mol_numaliphaticcarbocycles -> execute(mol, molDescRepository::molNumAliphaticCarbocycles);
            case mol_numsaturatedcarbocycles -> execute(mol, molDescRepository::molNumSaturatedCarbocycles);
            case mol_numspiroatoms -> execute(mol, molDescRepository::molNumSpiroAtoms);
            case mol_numbridgeheadatoms -> execute(mol, molDescRepository::molNumBridgeheadAtoms);
            case mol_inchi -> execute(mol, molDescRepository::molInchi);
            case mol_inchikey -> execute(mol, molDescRepository::molInchikey);
        };
    }

    @Override
    public String molFormula(Mol mol, Boolean bool1, Boolean bool2) {
        return null;
    }

    @Override
    public String molNmHash(Mol mol, String hashType) {
        return null;
    }
}
