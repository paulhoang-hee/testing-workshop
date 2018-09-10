package uk.nhs.hee.testees.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.nhs.hee.testees.entities.Account;
import uk.nhs.hee.testees.services.AccountService;

import java.util.Optional;

@RestController
public class AccountController {

  @Autowired
  private AccountService accountService;

  @GetMapping("/account/{id}/person/{personId}")
  public ResponseEntity<Account> getAccount(@PathVariable Long id, @PathVariable Long personId) {
    Optional<Account> account = accountService.getAccount(id, personId);
    if (account.isPresent()) {
      return ResponseEntity.ok(account.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/account")
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    return ResponseEntity.ok(accountService.createAccount(account));
  }

  @PutMapping("/account/credit/{id}")
  public ResponseEntity<Account> creditAccount(@PathVariable Long id, @RequestParam(name = "amount") Double amount) {
    Optional<Account> account = accountService.creditAccount(id, amount);
    if (account.isPresent()) {
      return ResponseEntity.ok(account.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/account/debit/{id}")
  public ResponseEntity<Account> debitAccount(@PathVariable Long id, @RequestParam(name = "amount") Double amount) {
    Optional<Account> account = accountService.debitAccount(id, amount);
    if (account.isPresent()) {
      return ResponseEntity.ok(account.get());
    }
    return ResponseEntity.notFound().build();
  }
}
