package hr.uniri.molapi.molecule.io;

public interface MolIoRepository {
    String molFrom(String molecule, String format);

    String molFrom(byte[] molecule, String format);

    String molTo(String molecule, String format);
}
