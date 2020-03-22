package br.com.fvs.routinetransactions.services;

import br.com.fvs.routinetransactions.models.Account;
import br.com.fvs.routinetransactions.models.OperationsType;
import br.com.fvs.routinetransactions.models.Transaction;
import br.com.fvs.routinetransactions.repository.AccountRepository;
import br.com.fvs.routinetransactions.repository.OperationsTypeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class TransactionServices {
    private AccountRepository accountRepository;
    private OperationsTypeRepository operationsTypeRepository;

    public TransactionServices(AccountRepository accountRepository,
                               OperationsTypeRepository operationsTypeRepository) {
        this.accountRepository = accountRepository;
        this.operationsTypeRepository = operationsTypeRepository;
    }

    public Transaction validate(Map<String, Object> payload) {
        Integer accountId = (Integer) payload.get("account_id");
        Integer operationTypeId = (Integer) payload.get("operation_type_id");
        Double amount = (Double) payload.get("amount");

        isAccountExists(accountId);
        isOperationValid(operationTypeId);

        Account account = new Account();
        account.setId(accountId);

        OperationsType operationsType = new OperationsType();
        operationsType.setId(operationTypeId);

        Transaction transaction = new Transaction();
        transaction.setAmount(sanitizeAmount(amount, operationTypeId));
        transaction.setAccount(account);
        transaction.setOperationsType(operationsType);

        return transaction;
    }

    private void isAccountExists(Integer accountId) {
        if (accountId != null && !accountRepository.existsById(accountId)) {
            throw new RuntimeException("Account must be exist");
        }
    }

    private void isOperationValid(Integer operationTypeId) {
        if (operationTypeId != null && !operationsTypeRepository.existsById(operationTypeId)) {
            throw new RuntimeException("Operation Type must be valid");
        }
    }

    private BigDecimal sanitizeAmount(Double amount, Integer operationTypeId) {
        BigDecimal newAmount = BigDecimal.valueOf(amount);

        if (amount != 0 && operationTypeId != 4) {
            return newAmount.multiply(BigDecimal.valueOf(-1));
        }

        return newAmount;
    }
}
