/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Mohamed Azouz <mohamedaliazouz@gmail.com>
 */
public class Commons {

    static public int toInt(String s) {
        return Integer.valueOf(s);
    }

    static HashMap<String, String> readhexaFile(String fileName) {
        HashMap<String, String> hashMap = null;
        try {
            File f = new File(fileName);
            hashMap = new HashMap<String, String>();
            Scanner s = new Scanner(f);
            int i = 0;
            while (s.hasNext()) {
                String key = s.next();
                String value = s.next();
                if (i++ == 0) {
                    key = key.substring(1);
                }
                hashMap.put(key.trim(), value.trim());
            }
            System.out.println(hashMap.get("0xFEF7"));

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            return hashMap;
        }
    }
}
