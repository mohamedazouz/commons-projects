/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Mohamed Azouz <mohamedaliazouz@gmail.com>
 */
public class DataRecord {

    private ArrayList<DataModel> dataModels;

    public DataRecord(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    /**
     * @return the dataModels
     */
    public ArrayList<DataModel> getDataModels() {
        return dataModels;
    }

    /**
     * @param dataModels the dataModels to set
     */
    public void setDataModels(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (DataModel dataModel : dataModels) {
            builder.append(dataModel);
        }
        return builder.toString();
    }
}
