package uk.nhs.hee.testees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.nhs.hee.testees.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
