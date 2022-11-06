package modelo;

/**
 *
 * @author Igorjr19
 */

public class Tecnico extends Funcionario {
    private String funcao;

    public Tecnico(String codigo, String nome, double salario, String nivel, String funcao) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario; //TODO - Perguntar quanto é o salário base
        
        if((nivel.equals("T1")) || (nivel.equals("T2"))) {
            this.nivel = nivel;
        } else {
            this.nivel = "Nivel inválido";
        }
        
        if((funcao.equals("Assessor")) || (funcao.equals("Laboratório")) || (funcao.equals("Secretário"))) {
            this.funcao = funcao;
        } else {
            this.funcao = "Funcao inválida";
        }
    }

    public String getFuncao() {
        return funcao;
    }
    
    @Override
    public double calcularSalario() {
        if(this.nivel.equals("T1")) {
            return (this.salario + Constantes.T1 * this.salario);
        } else if(this.nivel.equals("T2")) {
            return (this.salario + Constantes.T2 * this.salario);
        }
        return this.salario;
    }

    @Override
    public String dados() {
        String dados = "Nome: " + this.nome + "\n" +
                       "Codigo: " + this.codigo + "\n" +
                       "Categoria: Técnico\n" +
                       "Nivel: " + this.nivel + "\n" +
                       "Funcao: " + this.funcao + "\n" +
                       "Salario: " + this.calcularSalario() + "\n";
        return dados;
    }
}