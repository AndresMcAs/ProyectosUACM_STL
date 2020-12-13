
package modelo;

public class Proyecto {
     private int num;
     private String nombre;
     private String tipo;
     private String materia;
     private String semestre;
     
     
  public Proyecto()  {
     
}
  public Proyecto(int num, String nombre,String materia,String semestre)  {
    this.num=num;
    this.nombre=nombre;
    this.materia=materia;
    this.semestre=semestre;
  }
  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipo() {
    return tipo;
  }
 
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getMateria() {
    return materia;
  }

  public void setMateria(String materia) {
    this.materia = materia;
  }

  public String getSemestre() {
    return semestre;
  }

  public void setSemestre(String semestre) {
    this.semestre = semestre;
  }
     
     
}
