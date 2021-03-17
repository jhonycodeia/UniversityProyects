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

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class ChartView implements Serializable {

    private LineChartModel lineModel;
    private PieChartModel pieModel;

    @PostConstruct
    public void init() {
        initLinearModel();
        initPieModel();
	}

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }  
     
    private void initLinearModel() {
        lineModel = new LineChartModel();
        lineModel.setTitle("Linear Chart");
        lineModel.setLegendPosition("e");
        lineModel.setExtender("skinChart");
        lineModel.setAnimate(true);
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");

        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);

        lineModel.addSeries(series1);
        lineModel.addSeries(series2);
    }

    private void initPieModel() {
        pieModel = new PieChartModel();
        
        pieModel.set("Brand 1", 540);
        pieModel.set("Brand 2", 325);
        pieModel.set("Brand 3", 702);
        pieModel.set("Brand 4", 421);
        
        pieModel.setExtender("skinPie");
    }
    
}
