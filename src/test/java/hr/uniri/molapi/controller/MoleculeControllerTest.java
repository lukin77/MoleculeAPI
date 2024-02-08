package hr.uniri.molapi.controller;

import hr.uniri.molapi.model.Mol;
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
class MolControllerTest {

    public static final String BASE_URL = "/Mol";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Integer> getIds() {
        return jdbcTemplate.query("SELECT id FROM mols", (rs, num) -> rs.getInt("id"));
    }

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static Mol Mol;

    @BeforeAll
    static void setUp() {
        Mol = new Mol("c1ccccc1");
    }

    @AfterAll
    static void afterAll() {
        Mol = null;
    }

    @Test
    public void getAllMols() {
        List<Mol> mols = testRestTemplate.getForObject(BASE_URL, List.class);
        assertNotNull(mols);
        assertTrue(mols.size() > 50); // Using 50 for test purpose
    }

    @Test
    public void findMolById() {
        int id = Mol.getId();
        ResponseEntity<Mol> molResponseEntity = testRestTemplate.getForEntity(BASE_URL + "/".concat(Integer.toString(id)), Mol.class);
        assertEquals(HttpStatus.OK, molResponseEntity.getStatusCode());
        assertNotNull(molResponseEntity.getBody());
    }

    @Test
    public void deleteMolById() {
        int id = getIds().get(0);
        ResponseEntity<Mol> molResponseEntity = testRestTemplate.exchange(BASE_URL + "/".concat(Integer.toString(id)), HttpMethod.DELETE, HttpEntity.EMPTY, Mol.class);
        assertEquals(HttpStatus.OK, molResponseEntity.getStatusCode());
        assertNull(molResponseEntity.getBody());
    }

    @Test
    public void saveMol() {
        HttpEntity<Mol> request = new HttpEntity<>(Mol);
        ResponseEntity<Mol> molResponseEntity = testRestTemplate.exchange(BASE_URL, HttpMethod.POST, request, Mol.class);
        assertEquals(HttpStatus.CREATED, molResponseEntity.getStatusCode());

        Mol savedMol = molResponseEntity.getBody();
        assertNotNull(savedMol);
        assertEquals(savedMol.getStructure(), Mol.getStructure());
    }
}