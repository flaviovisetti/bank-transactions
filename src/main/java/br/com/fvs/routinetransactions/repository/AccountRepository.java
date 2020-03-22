package br.com.fvs.routinetransactions.repository;

import br.com.fvs.routinetransactions.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
