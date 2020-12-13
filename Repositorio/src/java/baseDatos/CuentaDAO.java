
package baseDatos;

import java.util.List;
import modelo.Cuenta;

/**
 *
 * @author Andres mendoza Contreras
 */
public interface CuentaDAO {
      public List<Cuenta>Consultar();
    public int Insertar(Cuenta cuenta);
    public int Actualiza(Cuenta cuenta);
    public int Borrar(Cuenta cuenta);
    
}
