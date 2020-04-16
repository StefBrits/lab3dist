package be.uantwerpen.lab3StefDistributed.controller;

import be.uantwerpen.lab3StefDistributed.database.BankRepository;
import be.uantwerpen.lab3StefDistributed.model.BankAccount;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class ServerController {

    private final BankRepository repository;

    ServerController(BankRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/accounts")
    List<BankAccount> all() {
        return repository.findAll();
    }

    @PostMapping("/accounts")
    BankAccount newAccount(@RequestBody BankAccount newAccount) {
        return repository.save(newAccount);
    }

    //

    @GetMapping("/accounts/{id}")
    BankAccount acc(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new BankAccountNotFoundException(id));
    }

    @PutMapping("/accounts/deposit/{id}/{amount}")
    Optional<BankAccount> depositMoney(@PathVariable Long id,@PathVariable int amount) {
        return repository.findById(id).map(bankAccount -> {
            bankAccount.setCapital(bankAccount.getCapital() + amount);
            return repository.save(bankAccount);
        });

    }

    @PutMapping("/accounts/withdraw/{id}/{amount}")
    Optional<BankAccount> withdrawMoney(@PathVariable Long id,@PathVariable int amount) {
        return repository.findById(id).map(bankAccount -> {
            bankAccount.setCapital(bankAccount.getCapital() - amount);
            return repository.save(bankAccount);
        });

    }

    /*
    @GetMapping("/test")
    @ResponseBody
    public int showTestAccount(){
        BankAccount account = new BankAccount("account-name","omo1");
        account.setCapital(1000);
        return account.getCapital();
    }

    @PutMapping("/makeAccount")
    public void makeAccount(){
        BankAccount bankAccount = new BankAccount("testMakeAcc","omo");
    }
    */

    @RequestMapping({"/","/home"})
    @ResponseBody
    public String showHomepage(){
        return "Hello world";
    }

    private class BankAccountNotFoundException extends RuntimeException {
        public BankAccountNotFoundException(Long id) {
            super("Could not find BankAccount" + id);
        }
    }
}