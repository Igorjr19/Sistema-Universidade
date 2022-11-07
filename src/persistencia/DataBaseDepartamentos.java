package persistencia;

import modelo.Departamento;

/**
 *
 * @author Igorjr19
 */

public class DataBaseDepartamentos {
    private Departamento departamentos[];
    
    public DataBaseDepartamentos() {
        departamentos = new Departamento[4];
        departamentos[0] = new Departamento("01", "Matematica");
        departamentos[1] = new Departamento("02", "Biologia");
        departamentos[2] = new Departamento("03", "Geografia");
        departamentos[3] = new Departamento("04", "Medicina");
    }

    public Departamento[] getDepartamentos() {
        return departamentos;
    }
    
    public Departamento buscarCodigo(String codigo) {
        for(int i = 0; i < 4; i++) {
            if(departamentos[i].getCodigo().equals(codigo)) {
                return departamentos[i];
            }
        }
        return null;
    }
    
    public Departamento buscarNome(String nome) {
        for(int i = 0; i < 4; i++) {
            if(departamentos[i].getNome().equals(nome)) {
                return departamentos[i];
            }
        }
        return null;
    }
  
}
