package com.jcuentas.inleggo.data.model;

/**
 * Created by Jose Cuentas Turpo on 13/07/2015 - 06:12 PM.
 * E-mail: jcuentast@gmail.com
 */
public class Gerencia {
    private int idResourceImage;
    private String deItem;


    public Gerencia(String deItem, int idResourceImage) {
        this.deItem = deItem;
        this.idResourceImage = idResourceImage;
    }

    public String getDeItem() {
        return deItem;
    }

    public void setDeItem(String deItem) {
        this.deItem = deItem;
    }

    public int getIdResourceImage() {
        return idResourceImage;
    }

    public void setIdResourceImage(int idResourceImage) {
        this.idResourceImage = idResourceImage;
    }
}
