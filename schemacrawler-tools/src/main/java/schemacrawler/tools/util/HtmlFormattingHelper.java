/* 
 *
 * SchemaCrawler
 * http://sourceforge.net/projects/schemacrawler
 * Copyright (c) 2000-2008, Sualeh Fatehi.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 */

package schemacrawler.tools.util;


import schemacrawler.tools.OutputFormat;
import sf.util.Utilities;

/**
 * Methods to format entire rows of output as HTML.
 * 
 * @author Sualeh Fatehi
 */
public final class HtmlFormattingHelper
  extends BaseTextFormattingHelper
{
  /**
   * HTML footer.
   */
  public static final String HTML_FOOTER = "</body>" + Utilities.NEWLINE
                                           + "</html>";
  /**
   * HTML header.
   */
  public static final String HTML_HEADER = htmlHeader();

  private static String htmlHeader()
  {
    final byte[] text = Utilities.readFully(HtmlFormattingHelper.class
      .getResourceAsStream("/schemacrawler-output.css"));
    final String styleSheet = new String(text);

    final String header = "" + "<?xml version='1.0' encoding='UTF-8'?>"
                          + Utilities.NEWLINE
                          + "<!DOCTYPE html"
                          + Utilities.NEWLINE
                          + "     PUBLIC \"-//W3C//DTD HTML 4.01 Strict//EN\""
                          + Utilities.NEWLINE
                          + "    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"
                          + Utilities.NEWLINE
                          + "<html xmlns='http://www.w3.org/1999/xhtml'>"
                          + Utilities.NEWLINE + "<head>" + Utilities.NEWLINE
                          + "  <title>SchemaCrawler Output</title>"
                          + Utilities.NEWLINE + "  <style type='text/css'>"
                          + Utilities.NEWLINE + styleSheet + Utilities.NEWLINE
                          + "  </style>" + Utilities.NEWLINE + "</head>"
                          + Utilities.NEWLINE + "<body>" + Utilities.NEWLINE;
    return header;
  }

  public HtmlFormattingHelper(OutputFormat outputFormat)
  {
    super(outputFormat);
  }

  public String createArrow()
  {
    return " &rarr; ";
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.tools.util.TextFormattingHelper#createDocumentEnd()
   */
  public String createDocumentEnd()
  {
    return HTML_FOOTER;
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.tools.util.TextFormattingHelper#createDocumentStart()
   */
  public String createDocumentStart()
  {
    return HTML_HEADER;
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.tools.util.TextFormattingHelper#createObjectEnd()
   */
  public String createObjectEnd()
  {
    return "</table>" + Utilities.NEWLINE + "<p></p>" + Utilities.NEWLINE;
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.tools.util.TextFormattingHelper#createObjectStart(java.lang.String)
   */
  public String createObjectStart(final String name)
  {
    String objectStart = "<table>" + Utilities.NEWLINE;
    if (!Utilities.isBlank(name))
    {
      objectStart = objectStart + "  <caption>" + name + "</caption>"
                    + Utilities.NEWLINE;
    }
    return objectStart;
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.tools.util.TextFormattingHelper#createPreformattedText(java.lang.String,
   *      java.lang.String)
   */
  public String createPreformattedText(final String id, final String text)
  {
    return String.format("<pre id=\'%s\'>%n%s</pre>", id, text);
  }

}
