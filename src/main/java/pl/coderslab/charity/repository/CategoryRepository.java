package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.Category;

@Repository
@Transactional

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    }

