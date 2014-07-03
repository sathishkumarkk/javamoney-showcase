/*
 * Copyright 2014 JUGChennai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.javamoney.showcase.utiity;

import java.math.BigDecimal;
import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.money.MonetaryContext;
import javax.money.NumberValue;

/**
 *
 * @author gshenoy
 */
public class TestAmountFactory implements MonetaryAmountFactory<MonetaryAmount> {

    static MonetaryContext CONTEXT = new MonetaryContext.Builder().setFixedScale(true).setMaxScale(0)
            .setPrecision(0).setAmountType(TestAmount.class).build();

    private CurrencyUnit currency;
    private Number number;
    private MonetaryContext monetaryContext = CONTEXT;

    @Override
    public Class<? extends MonetaryAmount> getAmountType() {
        return TestAmount.class;
    }

    @Override
    public MonetaryAmountFactory<MonetaryAmount> setCurrency(String currencyCode) {
        return this;
    }

    @Override
    public MonetaryAmountFactory<MonetaryAmount> setCurrency(CurrencyUnit currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public MonetaryAmountFactory<MonetaryAmount> setNumber(double number) {
        this.number = new BigDecimal(number);
        return this;
    }

    @Override
    public MonetaryAmountFactory<MonetaryAmount> setNumber(long number) {
        this.number = new BigDecimal(number);
        return this;
    }

    @Override
    public MonetaryAmountFactory<MonetaryAmount> setNumber(Number number) {
        this.number = new BigDecimal(number.toString());
        return this;
    }

    @Override
    public MonetaryAmountFactory<MonetaryAmount> setContext(MonetaryContext monetaryContext) {
        this.monetaryContext = monetaryContext;
        return this;
    }

    @Override
    public MonetaryAmountFactory<MonetaryAmount> setAmount(MonetaryAmount amount) {

        this.currency = amount.getCurrency();
        this.number = amount.getNumber().numberValue(BigDecimal.class);
        this.monetaryContext = new MonetaryContext.Builder(amount.getMonetaryContext())
                .setAmountType(CONTEXT.getAmountType()).build();
        return this;
    }

    @Override
    public MonetaryAmount create() {
        return create(number, currency);
    }

    @Override
    public MonetaryContext getDefaultMonetaryContext() {
        return CONTEXT;
    }

    @Override
    public MonetaryContext getMaximalMonetaryContext() {
        return CONTEXT;
    }

    @Override
    public NumberValue getMaxNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NumberValue getMinNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TestAmount create(Number number, CurrencyUnit currency) {
        return TestAmount.of(number, currency);
    }

}
