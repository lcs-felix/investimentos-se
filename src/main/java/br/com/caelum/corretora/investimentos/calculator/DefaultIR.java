package br.com.caelum.corretora.investimentos.calculator;

import br.com.caelum.corretora.investimentos.model.Investment;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.time.Period;

public class DefaultIR implements Tax {

    @Override
    public MonetaryAmount calculate(Investment investment) {

        Period period = Period.between(investment.getStartDate(), investment.getFinishDate().orElse(LocalDate.now()));

        if(period.getMonths() <= 12) {
            return investment.getQtdeInvestiment().multiply(0.25);
        } else if(period.getMonths() <= 24) {
            return investment.getQtdeInvestiment().multiply(0.20);
        } else {
            return investment.getQtdeInvestiment().multiply(0.15);
        }
    }
}
