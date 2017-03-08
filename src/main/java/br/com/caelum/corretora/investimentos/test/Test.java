package br.com.caelum.corretora.investimentos.test;

import br.com.caelum.corretora.investimentos.model.InvestimentFund;
import br.com.caelum.corretora.investimentos.model.Investment;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.CurrencyStyle;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.time.LocalDate;
import java.util.Locale;

public class Test {

    private static CurrencyUnit real = Monetary.getCurrency("BRL");

    public static void main(String[] args) {

        MonetaryAmount value = Money.of(200, real);

        Investment investment = new InvestimentFund(value, LocalDate.now());

        MonetaryAmount tax = investment.calculateTax();
        MonetaryAmountFormat format = MonetaryFormats
                .getAmountFormat(AmountFormatQueryBuilder.of(new Locale("pt", "BR")).set(CurrencyStyle.SYMBOL).build());

        System.out.println("O total de impostos a ser pago é: " + format.format(tax));
    }
}
