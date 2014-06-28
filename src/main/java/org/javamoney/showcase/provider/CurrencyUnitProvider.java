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
package org.javamoney.showcase.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.money.CurrencyUnit;
import javax.money.spi.CurrencyProviderSpi;
import org.javamoney.showcase.utiity.TestCurrencyUnit;

/**
 *
 * @author gshenoy
 */
public class CurrencyUnitProvider implements CurrencyProviderSpi {

    private static Map<String, Integer> numericCodesCache = new HashMap<String, Integer>();

    private static Integer DEFAULT_FRACTIONAL_DIGITS = 2;

    static {

        numericCodesCache.put("USD", 840);
        numericCodesCache.put("EUR", 978);

    }

    @Override
    public CurrencyUnit getCurrencyUnit(String currencyCode) {
        return new TestCurrencyUnit(currencyCode, numericCodesCache.get(currencyCode), DEFAULT_FRACTIONAL_DIGITS);
    }

    @Override
    public CurrencyUnit getCurrencyUnit(Locale locale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<CurrencyUnit> getCurrencies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
