package be.uantwerpen.lab3StefDistributed.database;

import be.uantwerpen.lab3StefDistributed.model.BankAccount;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(BankRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new BankAccount("epic spaarrekening", "Stef-Brits")));
            log.info("Preloading " + repository.save(new BankAccount("dikke spaarrekening", "Brecht-Verwulgen")));
            log.info("Preloading " + repository.save(new BankAccount("coole spaarrekening", "Jaime-Aru")));
        };
    }
}