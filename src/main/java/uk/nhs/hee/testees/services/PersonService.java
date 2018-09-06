package uk.nhs.hee.testees.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.nhs.hee.testees.entities.Person;
import uk.nhs.hee.testees.repositories.PersonRepository;

import java.util.Optional;

@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  public Person createPerson(Person person) {
    return personRepository.save(person);
  }

  public void deletePerson(Long id) {
    personRepository.deleteById(id);
  }

  public Optional<Person> findPerson(Long id) {
    return personRepository.findById(id);
  }
}
