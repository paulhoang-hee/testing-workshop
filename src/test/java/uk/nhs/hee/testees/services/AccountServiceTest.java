package uk.nhs.hee.testees.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.TestPropertySource;
import uk.nhs.hee.testees.repositories.AccountRepository;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

  @InjectMocks
  private AccountService testObj;

  @Mock
  private AccountRepository accountRepositoryMock;


  //What happens during class test?
  //do we use a stub here?
  @Test
  public void creditAccountShouldAddAmountToBalanceOfAccount() {

  }

  @Test(expected = RuntimeException.class)
  public void debitAccountShouldThrowExceptionWhenAccountHasInsufficientFunds() {

  }

}