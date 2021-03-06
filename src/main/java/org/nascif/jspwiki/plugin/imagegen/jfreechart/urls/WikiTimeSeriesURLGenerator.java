/* This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 */
package org.nascif.jspwiki.plugin.imagegen.jfreechart.urls;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;

import com.ecyrd.jspwiki.WikiContext;


/**
 * A URL generator for time series.
 *
 * @author Nascif A. Abousalh-Neto
 */
public class WikiTimeSeriesURLGenerator 
 extends WikiURLGenerator 
 implements XYURLGenerator, Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /** A formatter for the date. */
  private DateFormat dateFormat = DateFormat.getInstance();

  /**
   * Construct a TimeSeriesURLGenerator.
   *
   * @param dDateFormat  a formatter for the date.
   * @param sPrefix  the prefix of the URL.
   * @param sSeriesParameterName  the name of the series parameter in the URL.
   * @param sItemParameterName  the name of the item parameter in the URL.
   */
  public WikiTimeSeriesURLGenerator(WikiContext context) {
    this(null, context);
  }

  public WikiTimeSeriesURLGenerator(DateFormat dDateFormat, WikiContext cContext) {
    super(cContext);
    if (dDateFormat != null) { // uses default
      this.dateFormat = dDateFormat;
    }
  }

  /**
   * Generates a URL for a particular item within a series.
   *
   * @param dataset  the dataset.
   * @param series  the series number (zero-based index).
   * @param item  the item number (zero-based index).
   *
   * @return The generated URL.
   */
  public String generateURL(XYDataset dataset, int series, int item) {
    String seriesName = (String)dataset.getSeriesKey(series);

    if (seriesName == null) {
      long x = dataset.getX(series, item).longValue();
      String xValue = this.dateFormat.format(new Date(x));
      seriesName = xValue;
    }

    return generateURL(seriesName.toString());
  }
}
