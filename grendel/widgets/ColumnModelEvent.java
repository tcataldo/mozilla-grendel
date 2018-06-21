/* -*- Mode: java; indent-tabs-mode: nil; c-basic-offset: 2 -*-
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.  See
 * the License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is the Grendel mail/news client.
 *
 * The Initial Developer of the Original Code is Netscape Communications
 * Corporation.  Portions created by Netscape are Copyright (C) 1997
 * Netscape Communications Corporation.  All Rights Reserved.
 *
 * Created: Will Scullin <scullin@netscape.com>, 21 Aug 1997.
 */

package grendel.widgets;

import java.util.EventObject;

public class ColumnModelEvent extends EventObject {
  int fFirst;
  int fLast;

  public ColumnModelEvent(Object aSource, int aFirst, int aLast) {
    super(aSource);

    fFirst = aFirst;
    fLast = aLast;
  }

  public int getFirst() {
    return fFirst;
  }

  public int getLast() {
    return fLast;
  }
}
