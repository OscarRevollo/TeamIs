package t2company.com.uy.teamis.modelos;

public class Foro {

    private String titulo;
    private String descripcion;
    private String categoria;
    private String fecha;

    public Foro (String titulo,String descripcion,String categoria,String fecha){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.categoria=categoria;
        this.fecha=fecha;
    }

    public Foro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
