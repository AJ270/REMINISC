package com.example.hp.reminisce;

public class ModelPatient {

    private int image;
    private String name,mobile,graph;

    public ModelPatient(int image, String name, String mobile, String graph) {
        this.image = image;
        this.name = name;
        this.mobile = mobile;
        this.graph = graph;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
