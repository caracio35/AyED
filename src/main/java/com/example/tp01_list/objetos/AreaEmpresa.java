package com.example.tp01_list.objetos;

public class AreaEmpresa {
    private String area;
    private int tardanzaMensaje;

    public AreaEmpresa(String area, int tardanzaMensaje) {
        this.tardanzaMensaje = tardanzaMensaje;
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getTardanzaMensaje() {
        return tardanzaMensaje;
    }

    public void setTardanzaMensaje(int tardanzaMensaje) {
        this.tardanzaMensaje = tardanzaMensaje;
    }

    public String toString() {
        return area + " " + tardanzaMensaje;
    }
}
