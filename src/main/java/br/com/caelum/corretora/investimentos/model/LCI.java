package br.com.caelum.corretora.investimentos.model;

import org.javamoney.moneta.Money;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Optional;

public class LCI extends Investment {

    public LCI(MonetaryAmount qtdeInvestiment, LocalDate startDate, LocalDate finishDate) {
        super(qtdeInvestiment, startDate, Optional.ofNullable(finishDate));
    }

    @Override
    public MonetaryAmount calculateTax() {
        return Money.zero(Monetary.getCurrency("BRL"));
    }
}
