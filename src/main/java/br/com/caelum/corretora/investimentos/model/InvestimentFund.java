package br.com.caelum.corretora.investimentos.model;

import br.com.caelum.corretora.investimentos.calculator.DefaultIR;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Optional;

public class InvestimentFund extends Investment {

    public InvestimentFund(MonetaryAmount qtdeInvestiment, LocalDate startDate) {
        super(qtdeInvestiment, startDate, Optional.empty());
    }

    @Override
    public MonetaryAmount calculateTax() {
        MonetaryAmount tax = new DefaultIR().calculate(this);
        MonetaryAmount totalTaxes = tax.add((getQtdeInvestiment().multiply(0.01)));
        return totalTaxes;
    }
}
