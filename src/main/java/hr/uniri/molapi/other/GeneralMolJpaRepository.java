package hr.uniri.molapi.other;

import hr.uniri.molapi.model.Mol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralMolJpaRepository extends JpaRepository<Mol, Integer> {
}
