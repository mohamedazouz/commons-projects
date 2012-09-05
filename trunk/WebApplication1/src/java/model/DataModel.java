/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mohamed Azouz <mohamedaliazouz@gmail.com>
 */
public class DataModel{

    private String name;
    private int length;
    private String defaultValue = "";
    private int position;
    private int OldPostion;

    public DataModel(String name, int length, int position, int OldPostion) {
        this.name = name;
        this.length = length;
        this.position = position;
        this.OldPostion = OldPostion;
    }

    public DataModel() {
    }

    public DataModel(String value) {
        this.defaultValue = value;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return defaultValue;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the OldPostion
     */
    public int getOldPostion() {
        return OldPostion;
    }

    /**
     * @param OldPostion the OldPostion to set
     */
    public void setOldPostion(int OldPostion) {
        this.OldPostion = OldPostion;
    }

    @Override
    public String toString() {
        return "old Position = " + this.getOldPostion() + " \nLength = " + this.getLength() + "\n value = " + this.getValue()+"\n";
    }
    
}
