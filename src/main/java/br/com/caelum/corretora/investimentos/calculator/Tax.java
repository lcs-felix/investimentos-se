package br.com.caelum.corretora.investimentos.calculator;

import br.com.caelum.corretora.investimentos.model.Investment;

import javax.money.MonetaryAmount;

public interface Tax {

    MonetaryAmount calculate(Investment investment);
}
