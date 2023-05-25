package com.example.recyclerview;

public class DetallePerros {

    String perroNombre;
    int imagenHueso;
    String perroDescripcion;
    int imagen;

    public DetallePerros(String perroNombre, String perroDescripcion, int imagen, int imagenHueso) {
        this.perroNombre = perroNombre;
        this.imagenHueso = imagenHueso;
        this.perroDescripcion = perroDescripcion;
        this.imagen = imagen;
    }

    public String getPerroNombre() {
        return perroNombre;
    }

    public void setPerroNombre(String perroNombre) {
        this.perroNombre = perroNombre;
    }

    public int getImagenHueso() {
        return imagenHueso;
    }

    public void setImagenHueso(String perroRanking) {
        this.imagenHueso = imagenHueso;
    }

    public String getPerroDescripcion() {
        return perroDescripcion;
    }

    public void setPerroDescripcion(String perroDescripcion) {
        this.perroDescripcion = perroDescripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
