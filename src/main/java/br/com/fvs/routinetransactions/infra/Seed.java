package br.com.fvs.routinetransactions.infra;

import br.com.fvs.routinetransactions.models.OperationsType;
import br.com.fvs.routinetransactions.repository.OperationsTypeRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Seed implements ApplicationRunner {
    private OperationsTypeRepository operationsTypeRepository;

    public Seed(OperationsTypeRepository operationsTypeRepository) {
        this.operationsTypeRepository = operationsTypeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (operationsTypeRepository.count() == 0) {
            seedOperationsType();
        };
    }

    private void seedOperationsType() {
        OperationsType aVista = new OperationsType();
        OperationsType parcelada = new OperationsType();
        OperationsType saque = new OperationsType();
        OperationsType pagamento = new OperationsType();

        aVista.setDescription("COMPRA A VISTA");
        parcelada.setDescription("COMPRA PARCELADA");
        saque.setDescription("SAQUE");
        pagamento.setDescription("PAGAMENTO");

        operationsTypeRepository.save(aVista);
        operationsTypeRepository.save(parcelada);
        operationsTypeRepository.save(saque);
        operationsTypeRepository.save(pagamento);
    }
}
