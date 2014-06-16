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
package org.javamoney.showcase.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import org.javamoney.showcase.bean.CoreBean;

/**
 *
 * @author gshenoy
 */
public class CoreFunctionalityChangeListener implements ValueChangeListener {
    
    @Override
    public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
        
        CoreBean coreBean = (CoreBean) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("coreBean");
        coreBean.setFunctionality(event.getNewValue().toString());
    }
    
}
