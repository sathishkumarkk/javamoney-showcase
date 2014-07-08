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
import javax.money.NumberValue;

/**
 *
 * @author gshenoy
 */
public class BigDecimalUtil {

    public static BigDecimal of(Number num) {

        Class<?> clazz = num.getClass();

        if (clazz.equals(Long.class) || clazz.equals(Integer.class)
                || clazz.equals(Short.class) || clazz.equals(Byte.class)) {

            return new BigDecimal(num.longValue());

        } else if (clazz.equals(Float.class) || clazz.equals(Double.class)) {
            return new BigDecimal(num.toString());
        } else if (clazz.equals(BigDecimal.class)) {
            return (BigDecimal) num;
        } else if (num instanceof NumberValue) {
            return ((NumberValue) num).numberValue(BigDecimal.class);
        } else {

            BigDecimal result = null;
            try {
                result = new BigDecimal(num.toString());
            } catch (NumberFormatException e) {
            }
            if (result == null) {
                result = BigDecimal.valueOf(num.doubleValue());
            }
            return result;
        }

    }

}
