package br.com.caelum.corretora.investimentos.test;

import br.com.caelum.corretora.investimentos.model.CDB;
import br.com.caelum.corretora.investimentos.model.InvestimentFund;
import br.com.caelum.corretora.investimentos.model.Investment;
import br.com.caelum.corretora.investimentos.model.LCI;
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
    private static MonetaryAmountFormat format = MonetaryFormats
            .getAmountFormat(AmountFormatQueryBuilder.of(new Locale("pt", "BR")).set(CurrencyStyle.SYMBOL).build());

    public static void main(String[] args) {

        MonetaryAmount value = Money.of(200, real);

        Investment fund = new InvestimentFund(value, LocalDate.now());
        MonetaryAmount fundTax = fund.calculateTax();
        System.out.println("O total de impostos a ser pago é: " + format.format(fundTax)); // 52

        Investment cdb = new CDB(value, LocalDate.now(), LocalDate.of(2018, 12, 20));
        MonetaryAmount cdbTax = cdb.calculateTax();
        System.out.println("O total de impostos a ser pago é: " + format.format(cdbTax)); // 40

        Investment lci = new LCI(value, LocalDate.now(), LocalDate.of(2017, 05, 15));
        MonetaryAmount lciTax = lci.calculateTax();
        System.out.println("O total de impostos a ser pago é: " + format.format(lciTax)); // always 0
    }
}
