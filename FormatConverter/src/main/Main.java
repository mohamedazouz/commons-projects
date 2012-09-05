/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import commons.Commons;
import controller.DataController;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import model.DataModel;
import model.DataRecord;

/**
 *
 * @author Mohamed Azouz <mohamedaliazouz@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("=========================Input format========================");
        System.out.println("=============================================================");
        System.out.println("Write input file path");
        String fileName = scanner.nextLine().replace("\\", "\\\\");
//        String fileName = "C:\\Users\\221388\\Documents\\NetBeansProjects\\FormatConverter\\in.txt";//        String fileName = "C:\Users\221388\Documents\NetBeansProjects\FormatConverter\n - Copy.txt";
        System.out.println("filename =  " + fileName);
        System.out.println("=============================================================");
        System.out.println("Is file delimeted 1 for yes 2 for No");
        int isDelimited = Commons.toInt(scanner.nextLine());
        String delimiter = null;
//        String delimiter = ",";
        ArrayList<DataModel> dataInputModel = new ArrayList<DataModel>();
        if (isDelimited == 1) {
            System.out.println("what is delimiter?!");
            delimiter = scanner.nextLine();
            System.out.println("fieldsNumber =  " + delimiter);
        } else {
            System.out.println("=============================================================");
            System.out.println("Write # of fields");
            int fieldsNumber = Commons.toInt(scanner.nextLine());
            System.out.println("fieldsNumber =  " + fieldsNumber);
            for (int i = 0; i < fieldsNumber; i++) {
                System.out.println("what is field #" + (i + 1) + "'s length");
                int length = Commons.toInt(scanner.nextLine());
                DataModel dataModel = new DataModel();
                dataModel.setLength(length);
                dataInputModel.add(dataModel);
            }
        }
        System.out.println("=============================================================");
        System.out.println("=========================Output format========================");
        System.out.println("=============================================================");
        System.out.println("Write # of fields");
        int outputFieldsNumber = Commons.toInt(scanner.nextLine());
        System.out.println("=============================================================");
        System.out.println("Is file delimeted 1 for yes 2 for No");
        isDelimited = Commons.toInt(scanner.nextLine());
        String outputDelimiter = null;
        if (isDelimited == 1) {
            System.out.println("what is delimiter?!");
            outputDelimiter = scanner.nextLine();
            System.out.println("fieldsNumber =  " + outputDelimiter);
        }
        ArrayList<DataModel> dataOutputModel = new ArrayList<DataModel>();
        for (int i = 0; i < outputFieldsNumber; i++) {
//            System.out.println("what is field #" + (i + 1) + "'s default name");
//            String name = scanner.nextLine();
            System.out.println("what is field #" + (i + 1) + "'s length");
            int length = Commons.toInt(scanner.nextLine());
//            System.out.println("what is field #" + (i + 1) + "'s default value");
//            String defaultValue = scanner.nextLine();
            System.out.println("Is file field has mapped to old position 1 for yes 2 for No");
            int isOldOne = Commons.toInt(scanner.nextLine());
            int oldPosition = -1;
            if (isOldOne == 1) {
                System.out.println("what is field #" + (i + 1) + "'s old postion");
                oldPosition = Commons.toInt(scanner.nextLine());
            }

            DataModel dataModel = new DataModel();
            dataModel.setLength(length);
            //dataModel.setValue(defaultValue);
            dataModel.setPosition(i + 1);
            dataModel.setOldPostion(oldPosition);
            //dataModel.setName(name);
            dataOutputModel.add(dataModel);
        }
        DataRecord outputRecordDetails = new DataRecord(dataOutputModel);
        DataRecord inputRecordDetails = new DataRecord(dataInputModel);
        DataController controller = new DataController(delimiter, outputDelimiter, new File(fileName), inputRecordDetails, outputRecordDetails);
//        System.out.println("Write # of output fields");
//        int fieldsNumber = Commons.toInt(scanner.nextLine());
//        System.out.println("fieldsNumber =  " + fieldsNumber);
//        ArrayList<DataModel> dataOutputModel = new ArrayList<DataModel>();

        scanner.close();
    }
}
