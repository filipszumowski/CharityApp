package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;

@Repository

public interface DonationRepository extends JpaRepository<Donation, Integer> {

    @Query(value = "select sum (quantity) from Donation")
    Integer sumQuantity();
}


