/*
 * Copyright 2020 - Henrique Pereira
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

package AV3.org.ifc.pgm3.dao;

import AV3.org.ifc.pgm3.model.Pe;
import java.util.ArrayList;

public class PeDAO {
    private ArrayList<Pe> pes = new ArrayList();

	public ArrayList<Pe> retornarPes() {
		return pes;
    }
    
    public void incluirPe(Pe pe) {
		pes.add(pe);
	}
}
