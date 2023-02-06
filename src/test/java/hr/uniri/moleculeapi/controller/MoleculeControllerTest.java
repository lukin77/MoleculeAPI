package hr.uniri.moleculeapi.controller;

import hr.uniri.moleculeapi.model.Molecule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoleculeControllerTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final int NOT_EXISTING_ID = 500000;

    private List<Integer> getIds() {
        return jdbcTemplate.query("SELECT id FROM mols", (rs, num) -> rs.getInt("id"));
    }


    @Test
    public void getAllMolecules() {
        List<Molecule> Molecule = testRestTemplate.getForObject("/molecule", List.class);
        assertNotNull(Molecule);
        assertTrue(Molecule.size() > 50);
    }

    @Test
    public void findMoleculeById() {
        getIds().forEach(id -> {
            ResponseEntity<Molecule> moleculeResponseEntity = testRestTemplate.getForEntity("/molecule/".concat(Integer.toString(id)), Molecule.class);
            assertEquals(HttpStatus.OK, moleculeResponseEntity.getStatusCode());
            assertNotNull(moleculeResponseEntity.getBody());
        });
    }

    @Test
    public void deleteMoleculeById() {
        int id = getIds().get(0);
        ResponseEntity<Molecule> moleculeResponseEntity = testRestTemplate.exchange("/molecule/".concat(Integer.toString(id)), HttpMethod.DELETE, HttpEntity.EMPTY, Molecule.class);
        assertEquals(HttpStatus.OK, moleculeResponseEntity.getStatusCode());
        assertNull(moleculeResponseEntity.getBody());
    }
/*
    @Test
    public void saveMolecule() {
        Mol mol = new Mol("O=c1[nH]c(=S)[nH]c(-c2ccccc2)c1Cc1cccc2ccccc12");
        HttpEntity<Molecule> request = new HttpEntity<>(new Molecule(NOT_EXISTING_ID, mol));
        ResponseEntity<Molecule> moleculeResponseEntity = testRestTemplate.exchange("/molecule", HttpMethod.POST, request, Molecule.class);
        assertEquals(HttpStatus.CREATED, moleculeResponseEntity.getStatusCode());

        Molecule molecule = moleculeResponseEntity.getBody();
        assertNotNull(molecule);
        assertEquals(mol.getMol(), molecule.getMol().getMol());
    }*/
}