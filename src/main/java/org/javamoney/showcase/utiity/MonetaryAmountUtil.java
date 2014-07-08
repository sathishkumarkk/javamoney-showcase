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
import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;

/**
 *
 * @author gshenoy
 */
public class MonetaryAmountUtil {

    private static MonetaryAmountUtil instance = null;

    public static MonetaryAmountUtil get() {
        if (instance == null) {

            instance = new MonetaryAmountUtil();
        }
        return instance;
    }

    public TestAmount createWithFactory(long value, String currencyCode) {
        return new TestAmountFactory().create(value, MonetaryCurrencies.getCurrency(currencyCode));
    }

    public TestAmount create(long value, String currencyCode) {
        return TestAmount.of(value, MonetaryCurrencies.getCurrency(currencyCode));
    }

}
