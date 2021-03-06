/* 
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation; either version 2.1 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package org.nascif.jspwiki.plugin.imagegen.jfreechart;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;
import org.nascif.jspwiki.plugin.config.Customizer;
import org.nascif.jspwiki.plugin.imagegen.jfreechart.customizer.XYPlotCustomizer;
import org.nascif.jspwiki.plugin.imagegen.jfreechart.reader.ChartDataBuilder;
import org.nascif.jspwiki.plugin.imagegen.jfreechart.reader.XYDataBuilder;

import com.ecyrd.jspwiki.WikiContext;


public class XYLineChartPlugin extends JFreeChartPlugin {
  
  protected boolean isImapSupported() {
    return false;
  }
  
  protected ChartDataBuilder createBuilder() {
    return new XYDataBuilder();
  }
  
  protected AbstractRenderer createRenderer(WikiContext context) {
    XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
    if (useToolTips()) {
      renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
    }
    if (useImap()) {
      renderer.setURLGenerator(new StandardXYURLGenerator());
    }
    return (AbstractRenderer)renderer;
  }
  
  protected Plot createPlot(WikiContext context, Dataset dataset, AbstractRenderer renderer) {
    NumberAxis xAxis = new NumberAxis(m_xLabel);
    xAxis.setAutoRangeIncludesZero(false);
    NumberAxis yAxis = new NumberAxis(m_yLabel);
    XYPlot plot = new XYPlot((XYDataset)dataset, xAxis, yAxis, (XYItemRenderer)renderer);
    return plot;
  }

  @Override
  protected Customizer createPlotCustomizer() {
    return new XYPlotCustomizer();
  }
}
