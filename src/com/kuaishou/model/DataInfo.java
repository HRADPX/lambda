package com.kuaishou.model;


public class DataInfo {

    private int id;
    private int infoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public DataInfo(int id, int infoId) {
        this.id = id;
        this.infoId = infoId;
    }

    public DataInfo(int id) {
        this.id = id;
    }


    public DataInfo() {}

    @Override
    public String toString() {
        return "DataInfo{" +
                "id=" + id +
                ", infoId=" + infoId +
                '}';
    }
}
