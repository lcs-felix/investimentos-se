package br.com.caelum.corretora.investimentos.calculator;

import br.com.caelum.corretora.investimentos.model.Investment;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DefaultIR implements Tax {

    @Override
    public MonetaryAmount calculate(Investment investment) {

        long months = ChronoUnit.MONTHS.between(investment.getStartDate(), investment.getFinishDate().orElse(LocalDate.now()));

        if(months <= 12) {
            return investment.getQtdeInvestiment().multiply(0.25);
        } else if(months <= 24) {
            return investment.getQtdeInvestiment().multiply(0.20);
        } else {
            return investment.getQtdeInvestiment().multiply(0.15);
        }
    }
}
