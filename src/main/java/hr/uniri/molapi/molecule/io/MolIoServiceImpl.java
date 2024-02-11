package hr.uniri.molapi.molecule.io;

import com.google.gson.Gson;
import hr.uniri.molapi.model.enums.MolFromFormat;
import hr.uniri.molapi.model.enums.MolToFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import static hr.uniri.molapi.utils.ExecuteMethod.execute;

@Service
public class MolIoServiceImpl implements MolIoService {

    private final MolIoRepository molIoRepository;

    @Autowired
    public MolIoServiceImpl(MolIoRepository molIoRepository) {
        this.molIoRepository = molIoRepository;
    }

    @Override
    public String molFrom(MolInputOutputRequest molInputOutputRequest) {
        try {
            MolFromFormat molFromFormat = MolFromFormat.valueOf(molInputOutputRequest.getFormat());
            Object molecule = molInputOutputRequest.getMolecule();

            switch (molFromFormat) {
                case ctab, smiles:
                    return execute(molecule.toString(), molFromFormat.name(), molIoRepository::molFrom);
                case json:
                    Gson gson = new Gson();
                    String molJson = gson.toJson(molecule);
                    return execute(molJson, molFromFormat.name(), molIoRepository::molFrom);
                case pkl:
                    // Can't extract binary string (bytea) from database therefore I can't test this
                    // ERROR: problem generating molecule from blob data
                    return molIoRepository.molFrom(serializeObject(molecule), molFromFormat.name());
            }
        } catch (IllegalArgumentException e) {
            return String.format("format: %s not supported", molInputOutputRequest.getFormat());
        }
        return String.format("format: %s not supported", molInputOutputRequest.getFormat());
    }

    public static byte[] serializeObject(Object obj) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            return bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String molTo(MolInputOutputRequest molInputOutputRequest) {
        try {
            MolToFormat molToFormat = MolToFormat.valueOf(molInputOutputRequest.getFormat());
            Object molecule = molInputOutputRequest.getMolecule();

            return execute(molecule.toString(), molToFormat.name(), molIoRepository::molTo);
        } catch (IllegalArgumentException e) {
            return String.format("format: %s not supported", molInputOutputRequest.getFormat());
        }
    }
}
