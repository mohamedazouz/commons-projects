/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DataModel;
import model.DataRecord;

/**
 *
 * @author Mohamed Azouz <mohamedaliazouz@gmail.com>
 */
public class DataController {

    private ArrayList<DataRecord> dataOutputRecords;
    private ArrayList<DataRecord> dataInputRecords;
    private DataRecord inputRecordDetails;
    private DataRecord outputRecordDetails;
    private Scanner scanner;
    private String inputDelimiter;
    private String outputDelimiter;
    private InputStream inputFile;
    private String outputBuffer;

    public DataController(String inputDelimiter, String outputDelimiter, InputStream inputFile, DataRecord inputRecordDetails, DataRecord outputRecordDetails) {
        this.inputDelimiter = inputDelimiter;
        this.outputDelimiter = outputDelimiter;
        this.inputFile = inputFile;
        this.inputRecordDetails = inputRecordDetails;
        this.outputRecordDetails = outputRecordDetails;
        startconvert();
    }

    private void startconvert() {
        try {
            String charset = "IBM864";
            //InputStreamReader fileInputStream = new InputStreamReader(this.inputFile, ((Charset) Charset.availableCharsets().get(charset)));
            InputStreamReader fileInputStream = new InputStreamReader(this.inputFile);
            scanner = new Scanner(fileInputStream);
            dataInputRecords = new ArrayList<DataRecord>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                ArrayList<DataModel> inputdata = null;
                if (this.inputDelimiter != null) {
                    inputdata = parseRecordWithDelimiter(s);
                } else {
                    inputdata = parseRecordWithoutDelimiter(s);
                }
                dataInputRecords.add(new DataRecord(inputdata));
            }
            outputBuffer = genrateOutputFile();
            //System.out.println(dataInputRecords + " " + dataInputRecords.size());
        } catch (Exception ex) {
            Logger.getLogger(DataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<DataModel> parseRecordWithDelimiter(String s) {
        StringTokenizer st = new StringTokenizer(s, this.inputDelimiter);
        ArrayList<DataModel> inputdata = new ArrayList<DataModel>();
        while (st.hasMoreTokens()) {
            String fieldValue = st.nextToken();
            DataModel dataModel = new DataModel(fieldValue);
            inputdata.add(dataModel);
        }
        return inputdata;
    }

    private ArrayList<DataModel> parseRecordWithoutDelimiter(String s) {
        int cursor = 0;
        int index = 0;
        ArrayList<DataModel> inputdata = new ArrayList<DataModel>();
        int currentFieldLength = 0;
        while (cursor < s.length()) {
            currentFieldLength = this.inputRecordDetails.getDataModels().get(index).getLength();
            String fieldValue = s.substring(cursor, cursor + currentFieldLength);

            DataModel dataModel = new DataModel(fieldValue);
            inputdata.add(dataModel);
            index++;
            cursor += currentFieldLength;
        }
        //3756
        return inputdata;
    }

    private String genrateOutputFile() throws FileNotFoundException {
        StringBuilder buffer = new StringBuilder();
        ProtectionDomain domain = this.getClass().getProtectionDomain();
        String path = domain.getCodeSource().getLocation().getPath();
        String p_realPath = path.substring(path.indexOf("/"), path.indexOf("WEB-INF"));
        String filePath = p_realPath + "out.txt";
        PrintWriter file = new PrintWriter(filePath);
        for (DataRecord dataInputRecord : dataInputRecords) {
            StringBuilder record = new StringBuilder();
            for (DataModel outputModelField : outputRecordDetails.getDataModels()) {
                int position = outputModelField.getOldPostion();
                String value = "";
                int newLength = outputModelField.getLength();
                int extraZero = newLength;
                if (position != -1) {
                    DataModel dataModel = dataInputRecord.getDataModels().get(position - 1);
                    String oldValue = dataModel.getValue();
                    value = oldValue;
                    int oldLength = oldValue.length();
                    extraZero = newLength - oldLength;
                }
                for (int i = 0; i < extraZero; i++) {
                    value += "0";
                }
                record.append(value);
                if (this.outputDelimiter != null) {
                    record.append(this.outputDelimiter);
                }
            }
            file.println(record.toString());
        }
        file.flush();
        file.close();
        return filePath.substring(1);
    }

    /**
     * @return the outputBuffer
     */
    public String getOutputBuffer() {
        return outputBuffer;
    }
}
