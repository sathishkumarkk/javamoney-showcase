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

/**
 *
 * @author gshenoy
 */
@ManagedBean
@SessionScoped
public class CoreBean {
    
    private String functionality = "0";
    
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
    }
    
    public void cancel() {
        System.out.println("cancel()");
    }
    
    public boolean canShowCurrencyCode1() {
        return true;
    }
    
    public boolean canShowCurrencyCode2() {
        return getFunctionality().equals("1");
    }
    
}
