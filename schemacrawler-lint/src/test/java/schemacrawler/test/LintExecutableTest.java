/*
========================================================================
SchemaCrawler
http://www.schemacrawler.com
Copyright (c) 2000-2018, Sualeh Fatehi <sualeh@hotmail.com>.
All rights reserved.
------------------------------------------------------------------------

SchemaCrawler is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

SchemaCrawler and the accompanying materials are made available under
the terms of the Eclipse Public License v1.0, GNU General Public License
v3 or GNU Lesser General Public License v3.

You may elect to redistribute this code under any of these licenses.

The Eclipse Public License is available at:
http://www.eclipse.org/legal/epl-v10.html

The GNU General Public License v3 and the GNU Lesser General Public
License v3 are available at:
http://www.gnu.org/licenses/

========================================================================
*/

package schemacrawler.test;


import org.junit.Test;

import schemacrawler.test.utility.BaseLintExecutableTest;
import schemacrawler.tools.options.TextOutputFormat;

public class LintExecutableTest
  extends BaseLintExecutableTest
{

  @Test
  public void commandlineLintReport()
    throws Exception
  {
    executeLintCommandLine(TextOutputFormat.text,
                           null,
                           null,
                           "executableForLint");
  }

  @Test
  public void commandlineLintReportWithConfig()
    throws Exception
  {
    executeLintCommandLine(TextOutputFormat.text,
                           "/schemacrawler-linter-configs-test.xml",
                           null,
                           "executableForLintWithConfig");
  }

  @Test
  public void executableLintReport()
    throws Exception
  {
    executeLintExecutable(TextOutputFormat.text,
                          null,
                          null,
                          "executableForLint");
  }

  @Test
  public void executableLintReportWithConfig()
    throws Exception
  {
    executeLintExecutable(TextOutputFormat.text,
                          "/schemacrawler-linter-configs-test.xml",
                          null,
                          "executableForLintWithConfig");
  }

}
