package view;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
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
            fileName = "C:/azouz/NetBeansProjects/WebApplication1/input_single.txt";
            //fileName = "C:/azouz/NetBeansProjects/WebApplication1/input_2.txt";
            //fileName = "C:/azouz/work place/intput.txt";
            //getFileContent(fileName);
            String charset = "IBM864: csIBM864, ibm864, 864, cp864, ibm-864";
            charset = "csIBM864";
            charset = "ibm864";
            charset = "cp864";
            charset = "ibm-864";
            charset = "864";
            charset = "Cp864";
            charset = "IBM864";
            //getFileContent(fileName, charset);
            //getTryAnotherEncoder(fileName, charset);
            fileName = "C:\\azouz\\NetBeansProjects\\WebApplication1\\text_tyext.TXT";
            readbyte(fileName, charset);
            //System.out.println(((Charset) Charset.availableCharsets().get("UTF-8")).canEncode());
            //search("TECHNICAL DATE");
        } catch (Exception ex) {
            System.out.println("File not Exist" + ex);
        }

    }

    static void readbyte(String fileName, String charset) {
        try {
            InputStreamReader fileInputStream = new InputStreamReader(new FileInputStream(new File(fileName)));
            PrintWriter pw = new PrintWriter("C:/azouz/NetBeansProjects/WebApplication1/azouz.txt");
            HashMap<String, String> h = readhexaFile();
            while (fileInputStream.ready()) {
                int n = fileInputStream.read();
                pw.print((char) n);
//                String hex=Integer.toHexString(n | 0x10000).substring(1);
//                String key = "0x" + hex.toUpperCase();
//                String value = h.get(key);
//                if (value == null) {
//                    value = String.valueOf((char) n);
//                }
//                pw.print(value);
            }
            pw.flush();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static HashMap<String, String> hashMap = null;

    static void sethashmap() {
        hashMap.put("0xFEF71", "محمد");
        hashMap.put("0xFEF7", "لأ");
        hashMap.put("0xFEF8", "لأ");
        hashMap.put("0xFEFB", "لا");
        hashMap.put("0xFEFC", "لا");
        hashMap.put("0xFE84", "ا");
        hashMap.put("0xFE8E", "ا");
        hashMap.put("0xFE8F", "ب");
        hashMap.put("0xFE95", "ت");
        hashMap.put("0xFE99", "ث");
        hashMap.put("0xFE9D", "ج");
        hashMap.put("0xFEA1", "ح");
        hashMap.put("0xFEA5", "خ");
        hashMap.put("0x0660", "0");
        hashMap.put("0x0661", "1");
        hashMap.put("0x0662", "2");
        hashMap.put("0x0663", "3");
        hashMap.put("0x0664", "4");
        hashMap.put("0x0665", "5");
        hashMap.put("0x0666", "6");
        hashMap.put("0x0667", "7");
        hashMap.put("0x0668", "8");
        hashMap.put("0x0669", "9");
        hashMap.put("0xFED1", "ف");
        hashMap.put("0xFEB1", "س");
        hashMap.put("0xFEB5", "ش");
        hashMap.put("0xFEB9", "ص");
        hashMap.put("0xFE81", "اّ");
        hashMap.put("0xFE83", "أ");
        hashMap.put("0xFE85", "ؤ");
        hashMap.put("0xFECA", "ع");
        hashMap.put("0xFE8B", "ء");
        hashMap.put("0xFE8D", "ا");
        hashMap.put("0xFE91", "ب");
        hashMap.put("0xFE93", "ة");
        hashMap.put("0xFE97", "ت");
        hashMap.put("0xFE9B", "ث");
        hashMap.put("0xFE9F", "ج");
        hashMap.put("0xFEA3", "ح");
        hashMap.put("0xFEA7", "خ");
        hashMap.put("0xFEA9", "د");
        hashMap.put("0xFEAB", "ذ");
        hashMap.put("0xFEAD", "ر");
        hashMap.put("0xFEAF", "ز");
        hashMap.put("0xFEB3", "س");
        hashMap.put("0xFEB7", "ش");
        hashMap.put("0xFEBB", "ص");
        hashMap.put("0xFEBF", "ض");
        hashMap.put("0xFEC1", "ط");
        hashMap.put("0xFEC5", "ظ");
        hashMap.put("0xFECB", "ع");
        hashMap.put("0xFECF", "غ");
        hashMap.put("0xFEC9", "ع");
        hashMap.put("0xFED3", "ف");
        hashMap.put("0xFED7", "ق");
        hashMap.put("0xFEDB", "ك");
        hashMap.put("0xFEDF", "ل");
        hashMap.put("0xFEE3", "م");
        hashMap.put("0xFEE7", "ن");
        hashMap.put("0xFEEB", "ه");
        hashMap.put("0xFEED", "و");
        hashMap.put("0xFEEF", "ى");
        hashMap.put("0xFEF3", "ى");
        hashMap.put("0xFEBD", "ض");
        hashMap.put("0xFECC", "ع");
        hashMap.put("0xFECE", "غ");
        hashMap.put("0xFECD", "غ");
        hashMap.put("0xFEE1", "م");
        hashMap.put("0xFEE5", "ن");
        hashMap.put("0xFEE9", "ه");
        hashMap.put("0xFEEC", "ه");
        hashMap.put("0xFEF0", "ى");
        hashMap.put("0xFEF2", "ي");
        hashMap.put("0xFED0", "غ");
        hashMap.put("0xFED5", "ق");
        hashMap.put("0xFEF5", "لاّ");
        hashMap.put("0xFEF6", "لاّ");
        hashMap.put("0xFEDD", "ل");
        hashMap.put("0xFED9", "ك");
        hashMap.put("0xFEF1", "ي");

    }

    static HashMap<String, String> readhexaFile() {
        String fileName = "C:/azouz/NetBeansProjects/WebApplication1/hex - Copy - Copy.txt";

        try {
            File f = new File(fileName);
            hashMap = new HashMap<String, String>();
            sethashmap();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return hashMap;
        }
    }

    static void getTryAnotherEncoder(String fileName, String charset_) {
        Charset charset = Charset.forName(charset_);
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        try {
            // Convert a string to ISO-LATIN-1 bytes in a ByteBuffer
            // The new ByteBuffer is ready to be read.
            ByteBuffer bbuf = encoder.encode(CharBuffer.wrap("a string"));

            // Convert ISO-LATIN-1 bytes in a ByteBuffer to a character ByteBuffer and then to a string.
            // The new ByteBuffer is ready to be read.
            CharBuffer cbuf = decoder.decode(bbuf);
            String s = cbuf.toString();
        } catch (CharacterCodingException e) {
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

    static void search(String searchName) {
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
                    if (token.toLowerCase().equals(searchName.toLowerCase())) {
                        System.out.println(index);
                        System.exit(0);
                    }
                    index++;
                }

            }
            scanner.close();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
