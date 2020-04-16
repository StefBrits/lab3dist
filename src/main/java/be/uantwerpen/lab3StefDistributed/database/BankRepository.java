package be.uantwerpen.lab3StefDistributed.database;

import be.uantwerpen.lab3StefDistributed.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankAccount, Long> {

}