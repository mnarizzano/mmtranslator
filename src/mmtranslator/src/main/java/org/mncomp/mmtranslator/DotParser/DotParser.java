/**
 * This file contains the definition of the class DotParser
 * @author mnarizzano
 *
 */

package package org.mncomp.mmtranslator;

import java.io.FileInputStream;
import main.java.org.mncorp.MM;

/**
 * This Define all the methods that are necessary to parse a dot file.
 * @see ... for more details
 * @author mnarizzano
 *
 */
public class DotParser {
    private FileInputStream fileDot = null;      /* Input Stream*/
    private ArrayList<String> inputSignaiList;   /* Input Signals as String of Chars*/
    private ArrayList<String> outputSignalList;  /* Output Signals as String of Chars*/
    private MM mm;                               /* Output MM */
    
}
