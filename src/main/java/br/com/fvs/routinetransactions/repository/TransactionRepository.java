package br.com.fvs.routinetransactions.repository;

import br.com.fvs.routinetransactions.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
