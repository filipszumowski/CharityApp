package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;

@Repository

public interface InstitutionRepository extends JpaRepository<Institution, Integer>{

    @Query(value="select count(*) from Institution")
    Integer numberOfInstitutions();
}
