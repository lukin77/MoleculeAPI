package hr.uniri.molapi.molecule.io;

public interface MolIoService {

    String molFrom(MolInputOutputRequest molInputOutputRequest);

    String molTo(MolInputOutputRequest molInputOutputRequest);
}
