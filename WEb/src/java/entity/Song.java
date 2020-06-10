/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kienv
 */
public class Song {
    private String id;
    private String name;
    private  float price;
    private String sampleURL;
    private String fulURL;
    private String idC;
    private String idSg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSampleURL() {
        return sampleURL;
    }

    public void setSampleURL(String sampleURL) {
        this.sampleURL = sampleURL;
    }

    public String getFulURL() {
        return fulURL;
    }

    public void setFulURL(String fulURL) {
        this.fulURL = fulURL;
    }

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getIdSg() {
        return idSg;
    }

    public void setIdSg(String idSg) {
        this.idSg = idSg;
    }

    
}
