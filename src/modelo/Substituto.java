package modelo;

/**
 *
 * @author Igorjr19
 */

public class Substituto extends Docente{
    private int cargaHoraria;
    
    public Substituto(String codigo, String nome, double salario, String nivel, String titulacao, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario; //TODO - Perguntar quanto é o salário base
        
        if((nivel.equals("S1")) || (nivel.equals("S2"))) {
            this.nivel = nivel;
        } else {
            this.nivel = "Nivel invalido"; //TODO - O que fazer quando digitarem valores invalidos;
        }
        
        if((titulacao.equals("Graduação")) || (titulacao.equals("Mestrado")) || (titulacao.equals("Doutorado")) || (titulacao.equals("Livre-Docente")) || (titulacao.equals("Titular"))) {
            this.titulacao = titulacao;
        } else {
            this.titulacao = "Titualacao inválida";
        }
        
        if(cargaHoraria == 12 || cargaHoraria == 24) {
            this.cargaHoraria = cargaHoraria;
        } else {
            this.cargaHoraria = 0; //TODO - O que colocar como carga horaria padrao
        }
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    
    
    @Override
    public double calcularSalario() {
        if(this.nivel.equals("S1")) {
            return (this.salario + Constantes.S1 * this.salario);
        } else if(this.nivel.equals("S2")) {
            return (this.salario + Constantes.S2 * this.salario);        
        }
        return this.salario;
    }
    
    @Override
    public String dados() {
        String dados = "Nome: " + this.nome + "\n" +
                       "Código: " + this.codigo + "\n" +
                       "Categoria: Docente Substituto\n" +
                       "Titulacao: " + this.titulacao + "\n" +
                       "Nível: " + this.nivel + "\n" +
                       "Carga Horaria: " + this.cargaHoraria + "\n" +
                       "Salário: " + this.calcularSalario() + "\n";
        return dados;
    }
}
