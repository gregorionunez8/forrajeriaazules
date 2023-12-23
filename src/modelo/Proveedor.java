package modelo;

public class Proveedor {

    private int idProveedor;
    private String descripcion;
    private String direccion;
    private int estado;

    public Proveedor() {
        this.idProveedor = 0;
        this.descripcion = "";
        this.direccion = "";
        this.estado = 0;
    }

    public Proveedor(int idCategoria, String descripcion, String direccion, int estado) {
        this.idProveedor = idCategoria;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.estado = estado;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
