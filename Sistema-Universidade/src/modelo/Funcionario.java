package modelo;

/**
 *
 * @author Igorjr19
 */

public abstract class Funcionario {
    protected String codigo;
    protected String nome;
    protected double salario; //Salario base
    protected String nivel;
    
    public abstract double calcularSalario();
    public abstract String dados();

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getNivel() {
        return nivel;
    }
    
    
}
