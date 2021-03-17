/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.sentinel;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DualListModel;

@ManagedBean
public class PickListView {
        
    private DualListModel<String> cities;
    
    @PostConstruct
    public void init() {
        //Cities
        List<String> citiesSource = new ArrayList<String>();
        List<String> citiesTarget = new ArrayList<String>();
        
        citiesSource.add("San Francisco");
        citiesSource.add("London");
        citiesSource.add("Paris");
        citiesSource.add("Istanbul");
        citiesSource.add("Berlin");
        citiesSource.add("Barcelona");
        citiesSource.add("Rome");
        
        cities = new DualListModel<String>(citiesSource, citiesTarget);
    }

    public DualListModel<String> getCities() {
        return cities;
    }

    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }

}
