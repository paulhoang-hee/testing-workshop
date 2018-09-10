package uk.nhs.hee.testees.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.nhs.hee.testees.entities.Account;
import uk.nhs.hee.testees.entities.Person;
import uk.nhs.hee.testees.repositories.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public Optional<Account> getAccount(Long id, Long personId) {
    Person person = new Person();
    person.setId(personId);
    return accountRepository.findByIdAndAccountOwner(id, person);
  }

  public Account createAccount(Account account) {
    return accountRepository.save(account);
  }

  public Optional<Account> creditAccount(Long id, Double amount) {
    Optional<Account> optionalAccount = accountRepository.findById(id);

    if(optionalAccount.isPresent()) {
      Account account = optionalAccount.get();
      account.setBalance(account.getBalance() != null ? account.getBalance() + amount : 0D + amount);
      return Optional.of(accountRepository.save(account));
    } else {
      return Optional.empty();
    }
  }


  public Optional<Account> debitAccount(Long id, Double amount) {
    Optional<Account> optionalAccount = accountRepository.findById(id);

    if(optionalAccount.isPresent()) {
      Account account = optionalAccount.get();
      Double balance = account.getBalance() != null ? account.getBalance() : 0D;
      if((balance - amount) < 0 && !account.getAllowOverdraft()) {
        throw new RuntimeException("insufficient funds");
      } else {
        account.setBalance(balance - amount);
      }
      return Optional.of(accountRepository.save(account));
    } else {
      return Optional.empty();
    }
  }
}
