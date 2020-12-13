package modelo;
import java.util.ArrayList;


public final class Repositorio {
    
    private final  ArrayList<Estudiante> estudiantes;
    
    public Repositorio(){
        estudiantes= new ArrayList<Estudiante>();
		Cuenta cuenta= new Cuenta("123");
		Estudiante estudiante= new Estudiante("Jose", cuenta);
		setEstudiante(estudiante);
		System.out.println("Numero de cuenta de estudiante: "+cuenta.getId());
    
    }
    public void setEstudiante(Estudiante estudiante){
        
      estudiantes.add(estudiante);
    }
    public ArrayList<Estudiante> getEstudiantes(){
    return estudiantes;
    }
    
    // busca la cuenta del estudiante
    public Estudiante BuscaEstudiante(String ncuenta, String contra){
    
      Cuenta cuenta;
      Estudiante estudianteEncontrado=null;
    
      for(int i=0;i< estudiantes.size();i++){
         cuenta=estudiantes.get(i).getCuenta();
         if(ncuenta.equals(cuenta.getId())&& contra.equals(cuenta.getContrasena())){
            estudianteEncontrado=estudiantes.get(i);
        }
    }
    return estudianteEncontrado;
    }
    
}
