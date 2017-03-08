package br.com.caelum.corretora.investimentos.model;

import org.javamoney.moneta.Money;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Optional;

public class LCI extends Investment {

    public LCI(MonetaryAmount qtdeInvestiment, LocalDate startDate, Optional<LocalDate> finishDate) {
        super(qtdeInvestiment, startDate, finishDate);
    }

    @Override
    public MonetaryAmount calculateTax() {
        return Money.zero(Monetary.getCurrency("BLR"));
    }
}
