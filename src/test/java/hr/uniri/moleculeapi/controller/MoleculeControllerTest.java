package hr.uniri.moleculeapi.controller;

import hr.uniri.moleculeapi.model.Molecule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoleculeControllerTest {

    public static final String BASE_URL = "/molecule";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Integer> getIds() {
        return jdbcTemplate.query("SELECT id FROM mols", (rs, num) -> rs.getInt("id"));
    }

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static Molecule molecule;

    @BeforeAll
    static void setUp() {
        molecule = new Molecule("c1ccccc1");
    }

    @AfterAll
    static void afterAll() {
        molecule = null;
    }

    @Test
    public void getAllMolecules() {
        List<Molecule> molecules = testRestTemplate.getForObject(BASE_URL, List.class);
        assertNotNull(molecules);
        assertTrue(molecules.size() > 50); // Using 50 for test purpose
    }

    @Test
    public void findMoleculeById() {
        int id = molecule.getId();
        ResponseEntity<Molecule> moleculeResponseEntity = testRestTemplate.getForEntity(BASE_URL + "/".concat(Integer.toString(id)), Molecule.class);
        assertEquals(HttpStatus.OK, moleculeResponseEntity.getStatusCode());
        assertNotNull(moleculeResponseEntity.getBody());
    }

    @Test
    public void deleteMoleculeById() {
        int id = getIds().get(0);
        ResponseEntity<Molecule> moleculeResponseEntity = testRestTemplate.exchange(BASE_URL + "/".concat(Integer.toString(id)), HttpMethod.DELETE, HttpEntity.EMPTY, Molecule.class);
        assertEquals(HttpStatus.OK, moleculeResponseEntity.getStatusCode());
        assertNull(moleculeResponseEntity.getBody());
    }

    @Test
    public void saveMolecule() {
        HttpEntity<Molecule> request = new HttpEntity<>(molecule);
        ResponseEntity<Molecule> moleculeResponseEntity = testRestTemplate.exchange(BASE_URL, HttpMethod.POST, request, Molecule.class);
        assertEquals(HttpStatus.CREATED, moleculeResponseEntity.getStatusCode());

        Molecule savedMolecule = moleculeResponseEntity.getBody();
        assertNotNull(savedMolecule);
        assertEquals(savedMolecule.getStructure(), molecule.getStructure());
    }
}