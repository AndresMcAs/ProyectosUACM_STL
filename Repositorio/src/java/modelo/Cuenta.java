
package modelo;

public class Cuenta {
    private int id;
  
    private String contrasena;
    
    public Cuenta(){}
    
    public Cuenta(String contra){
    this.contrasena=contra;
    }
    public Cuenta(int id ,String contra){
        this.id=id;
        this.contrasena=contra;
    }

 

    public String getContrasena() {
    return contrasena;
    }

    public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   /*  metodos para la acciones que el estudiante puede realizar dentro de la plataforma*/
    public void AgregarProyecto(Proyecto p)  {
    
   }
    
    
    
}
