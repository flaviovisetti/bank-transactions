package br.com.fvs.routinetransactions.repository;

import br.com.fvs.routinetransactions.models.OperationsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationsTypeRepository extends JpaRepository<OperationsType, Integer> {
}
