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
 * Created: Terry Weissman <terry@netscape.com>, 28 Aug 1997.
 */

package grendel.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;

/** Implements an input stream that comes from just a portion of a file. */

class PartialFileInputStream extends FileInputStream {
  int remaining = 1 << 30;

  public PartialFileInputStream(File f, int start, int length)
    throws IOException, FileNotFoundException
  {
    super(f);
    skip(start);
    remaining = length;
  }

  public int read() throws IOException {
    if (remaining <= 0) return -1;
    remaining--;
    return super.read();
  }

  public int read(byte b[]) throws IOException {
    if (remaining <= 0) return -1;
    int result = super.read(b);
    if (result > 0) {
      if (result > remaining) result = remaining;
      remaining -= result;
    }
    return result;
  }

  public int read(byte b[], int off, int length) throws IOException {
    if (remaining <= 0) return -1;
    if (length > remaining) length = remaining;
    int result = super.read(b, off, length);
    if (result > 0) {
      if (result > remaining) result = remaining;
      remaining -= result;
    }
    return result;
  }


}



