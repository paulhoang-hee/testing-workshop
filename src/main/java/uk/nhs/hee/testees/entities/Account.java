package uk.nhs.hee.testees.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "balance")
  private Double balance;

  @OneToOne
  @JoinColumn(name = "person_id", nullable = false, unique = true)
  private Person accountOwner;

  @Column(name = "allowOverdraft")
  private Boolean allowOverdraft;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Person getAccountOwner() {
    return accountOwner;
  }

  public void setAccountOwner(Person accountOwner) {
    this.accountOwner = accountOwner;
  }

  public Boolean getAllowOverdraft() {
    return allowOverdraft;
  }

  public void setAllowOverdraft(Boolean allowOverdraft) {
    this.allowOverdraft = allowOverdraft;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return Objects.equals(id, account.id) &&
        Objects.equals(balance, account.balance) &&
        Objects.equals(accountOwner, account.accountOwner) &&
        Objects.equals(allowOverdraft, account.allowOverdraft);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, balance, accountOwner, allowOverdraft);
  }
}
