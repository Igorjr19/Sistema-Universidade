package modelo;

import persistencia.DataBaseFuncionarios;

/**
 *
 * @author Igorjr19
 */

public class Departamento {
    private String codigo;
    private String nome;
    protected DataBaseFuncionarios db = new DataBaseFuncionarios();

    public Departamento(String codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    
    public void adicionarFuncionario(Funcionario func) {
        this.db.adicionarFuncionario(func);
    }
    
    public String exibirTodosFuncionarios() {
        Funcionario func[] = db.getFuncionarios();
        int cont = db.getNumFuncionarios();
        String relatorio = "";
        for(int i = 0; i < cont; i++) {
            if(func[i] != null) {
                relatorio = relatorio + func[i].dados();
                relatorio = relatorio + "\n";
            }
        }
        return relatorio;
    }
    
    public String exibirTodosFuncionariosFaixa(double min, double max) {
        Funcionario func[] = db.getFuncionarios();
        int cont = db.getNumFuncionarios();
        String relatorio = "";
        for(int i = 0; i < cont; i++) {
            if(func[i] != null && func[i].calcularSalario() >= min && func[i].calcularSalario() <= max) {
                relatorio = relatorio + func[i].dados();
                relatorio = relatorio + "\n";
            }
        }
        return relatorio;
    }
    
    public String exibirFuncionariosTecnicos() {
        Funcionario func[] = db.getFuncionarios();
        int cont = db.getNumFuncionarios();
        String relatorio = "";
        for(int i = 0; i < cont; i++) {
            if(func[i] != null && (func[i].getNivel().equals("T1") || func[i].getNivel().equals("T2"))) {
                relatorio = relatorio + func[i].dados();
                relatorio = relatorio + "\n";
            }
        }
        return relatorio;
    }
    
    public String exibirFuncionariosDocentes() {
        Funcionario func[] = db.getFuncionarios();
        int cont = db.getNumFuncionarios();
        String relatorio = "";
        for(int i = 0; i < cont; i++) {
            if(func[i] != null && (func[i].getNivel().equals("D1")) || func[i].getNivel().equals("D2") || func[i].getNivel().equals("D3") || func[i].getNivel().equals("S1") || func[i].getNivel().equals("S2")) {
                relatorio = relatorio + func[i].dados();
                relatorio = relatorio + "\n";
            }
        }
        return relatorio;
    }
    
    public String exibirFuncionariosEfetivos() {
        Funcionario func[] = db.getFuncionarios();
        int cont = db.getNumFuncionarios();
        String relatorio = "";
        for(int i = 0; i < cont; i++) {
            if(func[i] != null && (func[i].getNivel().equals("D1")) || func[i].getNivel().equals("D2") || func[i].getNivel().equals("D3")) {
                relatorio = relatorio + func[i].dados();
                relatorio = relatorio + "\n";
            }
        }
        return relatorio;
    }
    
    
    public String exibirFuncionariosSubstitutos() {
        Funcionario func[] = db.getFuncionarios();
        int cont = db.getNumFuncionarios();
        String relatorio = "";
        for(int i = 0; i < cont; i++) {
            if(func[i] != null && (func[i].getNivel().equals("S1")) || func[i].getNivel().equals("S2")) {
                relatorio = relatorio + func[i].dados();
                relatorio = relatorio + "\n";
            }
        }
        return relatorio;
    }
    
    public String resumoDepartamento() {
        Funcionario func[] = db.getFuncionarios();
        int cont = db.getNumFuncionarios();
        int nFunc = 0;
        double totalSal = 0;
        for(int i = 0; i < cont; i++) {
            if(func[i] != null) {
                nFunc++;
                totalSal += func[i].calcularSalario();
            }
        }
        String res = "Nome do Departamento: " + this.nome + "\n" +
                     "Código: " + this.codigo + "\n" +
                     "Numero de Funcionarios: " + nFunc + "\n" +
                     "Gasto Total com Funcionarios: " + totalSal + "\n";
        
        return res;
    }
    
    public double gastoFuncionarios() {
        Funcionario func[] = db.getFuncionarios();
        int cont = db.getNumFuncionarios();
        double totalSal = 0;
        for(int i = 0; i < cont; i++) {
            totalSal += func[i].calcularSalario();
        }
        return totalSal;
    }
}
