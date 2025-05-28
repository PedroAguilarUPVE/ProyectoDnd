package modelos;

public class OSubclase {
    private int id_Subclase;
    private int id_Clase;
    private String nombreSubclase;
    private String descripcionSubclase;

    // Getters y Setters
    public int getId_Subclase() {
        return id_Subclase;
    }

    public void setId_Subclase(int id_Subclase) {
        this.id_Subclase = id_Subclase;
    }

    public int getId_Clase() {
        return id_Clase;
    }

    public void setId_Clase(int id_Clase) {
        this.id_Clase = id_Clase;
    }

    public String getNombreSubclase() {
        return nombreSubclase;
    }

    public void setNombreSubclase(String nombreSubclase) {
        this.nombreSubclase = nombreSubclase;
    }

    public String getDescripcionSubclase() {
        return descripcionSubclase;
    }

    public void setDescripcionSubclase(String descripcionSubclase) {
        this.descripcionSubclase = descripcionSubclase;
    }
}