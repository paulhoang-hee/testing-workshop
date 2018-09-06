package uk.nhs.hee.testees.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.nhs.hee.testees.entities.Person;
import uk.nhs.hee.testees.services.PersonService;

import java.util.Optional;

@RestController
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping(path = "/person")
  public ResponseEntity<Person> createPerson(@RequestBody Person person) {
    Person person1 = personService.createPerson(person);
    return new ResponseEntity<>(person1, HttpStatus.OK);
  }

  @DeleteMapping(path = "/person/{id}")
  public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
    personService.deletePerson(id);
    return ResponseEntity.ok().build();
  }

  @GetMapping(path = "/person/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable Long id) {
    Optional<Person> person = personService.findPerson(id);
    if(person.isPresent()){
      return ResponseEntity.ok(person.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
