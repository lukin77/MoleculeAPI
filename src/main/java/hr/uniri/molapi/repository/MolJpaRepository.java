package hr.uniri.molapi.repository;

import hr.uniri.molapi.model.Mol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MolJpaRepository extends JpaRepository<Mol, Integer> {
}
