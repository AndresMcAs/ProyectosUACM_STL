
package modelo;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private String carrera;
    private String matricula;
    private Cuenta cuenta;
    
    public Estudiante(){}
    
    public Estudiante(String nombre, Cuenta cuenta) {
      this.nombre=nombre;
     this.cuenta=cuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getNombre() {
    return nombre;
    }

    public void setNombre(String nombre) {
    this.nombre = nombre;
    }
  

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    @Override
     public String toString() {
		String cadena=null;
		cadena="Id:"+id+" Nombre:"+nombre+" Apellido:"+apellido+"\n";	
		return cadena;
	}
}
