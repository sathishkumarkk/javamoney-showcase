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
package org.javamoney.showcase.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.money.CurrencyUnit;
import org.javamoney.showcase.utiity.CurrencyUtil;

/**
 *
 * @author gshenoy
 */
@ManagedBean
@SessionScoped
public class CoreBean {

    private String functionality = "0";
    private String result = "";

    private String currencyCode1 = "";

    private String currencyCode2 = "";

    public CoreBean() {

    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public void test() {
        System.out.println("test()");

        int fun = Integer.parseInt(getFunctionality());
        CurrencyUnit cu;
        switch (fun) {

            case 0:

                cu = CurrencyUtil.get().createCurrencyUnit(getCurrencyCode1());

                if (cu != null) {

                    result = formatResult(cu);

                }

                break;

            case 1:

                boolean equal = CurrencyUtil.get().equalsCurrencyUnits(getCurrencyCode1(), getCurrencyCode2());

                result = "The currency units are " + (equal ? "Equal" : "Not equal");

                break;

            case 2:
                cu = CurrencyUtil.get().createCurrencyUnit(getCurrencyCode1());
                result = "Currency unit= " + cu.getCurrencyCode();
                break;

            case 3:
                cu = CurrencyUtil.get().createCurrencyUnit(getCurrencyCode1());
                result = "Numeric code= " + cu.getNumericCode();
                break;

            case 4:
                cu = CurrencyUtil.get().createCurrencyUnit(getCurrencyCode1());
                result = "Default Fractional digits= " + cu.getDefaultFractionDigits();
                break;

        }

    }

    public void cancel() {
        result = "";
    }

    public boolean canShowCurrencyCode1() {
        return true;
    }

    public boolean canShowCurrencyCode2() {
        return getFunctionality().equals("1");
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCurrencyCode1() {
        return currencyCode1;
    }

    public void setCurrencyCode1(String currencyCode1) {
        this.currencyCode1 = currencyCode1;
    }

    public String getCurrencyCode2() {
        return currencyCode2;
    }

    public void setCurrencyCode2(String currencyCode2) {
        this.currencyCode2 = currencyCode2;
    }

    private String formatResult(CurrencyUnit cu) {

        return "Currency Code= " + cu.getCurrencyCode() + " Fractional digits= " + cu.getDefaultFractionDigits()
                + " Numeric code= " + cu.getNumericCode();

    }

}
