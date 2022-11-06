package persistencia;

import modelo.Funcionario;

/**
 *
 * @author Igorjr19
 */

public class DataBaseFuncionarios {
    private Funcionario funcionarios[];
    private int MAX; 
    private int cont; 
    
    public DataBaseFuncionarios() {
        this.MAX = 100;
        this.cont = 0;
        funcionarios = new Funcionario[MAX];
    }

    public Funcionario[] getFuncionarios() {
        return this.funcionarios;
    }

    public int getNumFuncionarios() {
        return this.cont;
    }
    
    public Funcionario buscarCodigo(String codigo) {
        for(int i = 0; i < cont; i++) {
            if(funcionarios[i].getCodigo().equals(codigo)) {
                return funcionarios[i];
            }
        }
        return null;
    }
    
    public Funcionario buscarNome(String nome) {
        for(int i = 0; i < cont; i++) {
            if(funcionarios[i].getNome().equals(nome)) {
                return funcionarios[i];
            }
        }
        return null;
    }
    
    public int adicionarFuncionario(Funcionario func) { //Retorna 1 se adicionou o funcionario, caso contrario retorna 0
        if(cont < MAX) {
            this.funcionarios[cont] = func;
            cont++;
            return 1;
        } else {
            return 0;
        }
    }
}
