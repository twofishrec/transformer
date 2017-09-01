package org.sandbox.data;

public class TransformationData {

    private int data;
    private String numberName;

    public TransformationData(int data, String numberName) {
        this.data=data;
        this.numberName = numberName;
    }

    public int getData() {
        return data;
    }

    public String getNumberName() {
        return numberName;
    }

}
