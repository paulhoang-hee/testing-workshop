package uk.nhs.hee.testees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.nhs.hee.testees.entities.Account;
import uk.nhs.hee.testees.entities.Person;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

  Optional<Account> findByIdAndAccountOwner(Long id, Person person);
}
