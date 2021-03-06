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
package org.nascif.jspwiki.plugin.imagegen.jfreechart.reader;

/**
 * 
 * @author <a href="mailto:naabou@wnt.sas.com">Nascif A. Abousalh Neto</a>
 */
public class NumberMetadata extends MetadataEntry {

  public NumberMetadata(String aName) {
    super(aName);
  }

  public Object parse(int lineNumber, String value) {
    Double result = null;
    try {
      result = Double.valueOf(value);
    } catch (NumberFormatException e) {
      throw new ChartReaderException(lineNumber, "Value can't be parsed as number: " + value);
    }
    return result;
  }

  public String toString() {
    return "NE(" + getName() + ")";
  }
  
}

