package hr.uniri.molapi.molecule.connectivityDescriptors;

import hr.uniri.molapi.model.enums.ConnectivityDescriptor;
import hr.uniri.molapi.model.Mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hr.uniri.molapi.utils.ExecuteMethod.execute;

@Service
public class MolConDescServiceImpl implements MolConDescService {

    private final MolConDescRepository molConDescRepository;

    @Autowired
    public MolConDescServiceImpl(MolConDescRepository molConDescRepository) {
        this.molConDescRepository = molConDescRepository;
    }

    @Override
    public Float connectivityDescription(MolConDescRequest molConDescRequest) {
        ConnectivityDescriptor connectivityDescriptor = ConnectivityDescriptor.valueOf(molConDescRequest.getConnectivityDescriptor());
        Mol mol = new Mol(molConDescRequest.getSmiles());

        return switch (connectivityDescriptor) {
            case mol_chi0v -> execute(mol, molConDescRepository::molChi0v);
            case mol_chi1v -> execute(mol, molConDescRepository::molChi1v);
            case mol_chi2v -> execute(mol, molConDescRepository::molChi2v);
            case mol_chi3v -> execute(mol, molConDescRepository::molChi3v);
            case mol_chi4v -> execute(mol, molConDescRepository::molChi4v);
            case mol_chi0n -> execute(mol, molConDescRepository::molChi0n);
            case mol_chi1n -> execute(mol, molConDescRepository::molChi1n);
            case mol_chi2n -> execute(mol, molConDescRepository::molChi2n);
            case mol_chi3n -> execute(mol, molConDescRepository::molChi3n);
            case mol_kappa1 -> execute(mol, molConDescRepository::molKappa1);
            case mol_kappa2 -> execute(mol, molConDescRepository::molKappa2);
            case mol_kappa3 -> execute(mol, molConDescRepository::molKappa3);
            case mol_phi -> execute(mol, molConDescRepository::molPhi);
            case mol_hallkieralpha -> execute(mol, molConDescRepository::molHallkieralpha);
        };
    }
}
