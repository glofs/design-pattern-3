package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class WithDrawDecorator extends AccountDecorator {
    public static final double LIMIT_WITH_DRAW = 20000.0;

    public WithDrawDecorator(Account account) {
        super(account);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        System.out.println("balance actual"+this.getBalance());
        double balance = this.getBalance();
        if (amount - balance > LIMIT_WITH_DRAW) {
            System.out.println("se excedio el limite de endeudamiento, no se puede realizar el retiro, el balance es" + this.getBalance());
        } else {
            if ((amount - balance) >= 0.0 && (amount - balance) < LIMIT_WITH_DRAW) {
                double extraCost =this.getBalance();
                this.setBalance(0.0);
                System.out.println("se realizó el retiro, el nuevo saldo es " + this.getBalance() + "con un endeudamiento de " + -extraCost);
            } else {
                System.out.println("se realizó el retiro, el nuevo saldo es " + this.getBalance());
            }

        }
    }
}
