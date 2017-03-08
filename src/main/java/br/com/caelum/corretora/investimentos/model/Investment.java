package br.com.caelum.corretora.investimentos.model;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Optional;

public abstract class Investment {

    private MonetaryAmount qtdeInvestiment;

    private LocalDate startDate;

    private Optional<LocalDate> finishDate;

    public Investment(MonetaryAmount qtdeInvestiment, LocalDate startDate, Optional<LocalDate> finishDate) {
        this.qtdeInvestiment = qtdeInvestiment;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public MonetaryAmount getQtdeInvestiment() {
        return qtdeInvestiment;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Optional<LocalDate> getFinishDate() {
        return finishDate;
    }

    public abstract MonetaryAmount calculateTax();
}
