package br.com.caelum.corretora.investimentos.model;

import br.com.caelum.corretora.investimentos.calculator.DefaultIR;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Optional;

public class CDB extends Investment {

    public CDB(MonetaryAmount qtdeInvestiment, LocalDate startDate, LocalDate finishDate) {
        super(qtdeInvestiment, startDate, Optional.ofNullable(finishDate));
    }

    @Override
    public MonetaryAmount calculateTax() {
        return new DefaultIR().calculate(this);
    }
}
