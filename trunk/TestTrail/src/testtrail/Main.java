/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testtrail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 221388
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String fileName = "C:/azouz/NetBeansProjects/WebApplication1/in.txt";
            //fileName = "C:/azouz/NetBeansProjects/WebApplication1/in_single.txt";
            fileName = "C:/azouz/NetBeansProjects/WebApplication1/input_2.txt";
            //getFileContent(fileName);
            String charset = "IBM864: csIBM864, ibm864, 864, cp864, ibm-864";
            charset = "csIBM864";
            charset = "ibm864";
            charset = "cp864";
            charset = "ibm-864";
            charset = "864";
            charset = "Cp864";
            charset = "IBM864";
//            getFileContent(fileName, charset);
//            System.out.println(((Charset) Charset.availableCharsets().get("UTF-8")).canEncode());

            System.out.println(search("Branch Code"));
        } catch (Exception ex) {
            System.out.println("File not Exist" + ex);
        }

    }

    static void getFileContent(String fileName, String charset) {
        try {
            InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(new File(fileName)), ((Charset) Charset.availableCharsets().get(charset)));
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(s, ";");
                while (st.hasMoreTokens()) {
                    System.out.print(st.nextToken());
                }
                System.out.println("");
            }
            scanner.close();
            fileInputStream.close();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void getCharset() {
        Map charSets = Charset.availableCharsets();
        Iterator it = charSets.keySet().iterator();
        while (it.hasNext()) {
            String csName = (String) it.next();
            System.out.print(csName);
            Iterator aliases = ((Charset) charSets.get(csName)).aliases().iterator();
            if (aliases.hasNext()) {
                System.out.print(": ");
            }
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    static void getScannerFile(String fileName, String charset) {
        try {
            int linenumber = 0;

            Scanner scanner = new Scanner(new File(fileName), charset);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                System.out.println(s);
                StringTokenizer st = new StringTokenizer(s, ";");
                while (st.hasMoreTokens()) {
                    System.out.println(st.nextToken());
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static String search(String searchName) {
        try {
            String ss = "BRANCH CODE;RECEIVE DATE;BILL NUMBER;CUSTOMER NUMBER;DUE DATE;CUSTOMER REFERENCE;BILL VALUE;COLLECTOR TYPE;COLLECTOR CODE;LAG;DELAY DATE;PROTESTO TYPE;ACCOUNT NUMBER;ADDRESS NUMBER;TECHNICAL DATE;BILL TYPE;BILL STATUS;PROTESTO DATE;DRAWEE NAME;DRAWEE ADDRESS;DRAWER NAME";
            Scanner scanner = new Scanner((ss));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                System.out.println(s);
                StringTokenizer st = new StringTokenizer(s, ";");
                int index = 1;
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    /*if (token.toLowerCase().equals(searchName.toLowerCase())) {
                        System.out.println(index);
                        return String.valueOf(index);
                    }*/
                    index++;
                    System.out.println(index);
                }

            }
            scanner.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "";
    }
}
