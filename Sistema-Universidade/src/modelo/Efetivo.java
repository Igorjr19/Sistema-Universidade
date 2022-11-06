package modelo;

/**
 *
 * @author Igorjr19
 */

public class Efetivo extends Docente{
    private String area;
    
    public Efetivo(String codigo, String nome, double salario, String nivel, String titulacao, String area){
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario; //TODO - Perguntar quanto é o salário base
        
        if((nivel.equals("D1")) || (nivel.equals("D2")) || (nivel.equals("D3"))) {
            this.nivel = nivel;
        } else {
            this.nivel = "Nivel invalido";
        }
        
        if((titulacao.equals("Graduação")) || (titulacao.equals("Mestrado")) || (titulacao.equals("Doutorado")) || (titulacao.equals("Livre-Docente")) || (titulacao.equals("Titular"))) {
            this.titulacao = titulacao;
        } else {
            this.titulacao = "Titualacao invalida";
        }
        
        if((area.equals("Exatas")) || (area.equals("Humanas")) || (area.equals("Biológicas")) || (area.equals("Saúde"))) {
            this.area = area;
        } else {
            this.area = "Area inválida";
        }
    }

    public String getArea() {
        return area;
    }

    @Override
    public double calcularSalario() {
        if(this.nivel.equals("D1")) {
            return (this.salario + Constantes.D1 * this.salario + Constantes.Efetivo * this.salario);
        } else if(this.nivel.equals("D2")) {
            return (this.salario + Constantes.D2 * this.salario + Constantes.Efetivo * this.salario);        
        } else if(this.nivel.equals("D3")) {
            return (this.salario + Constantes.D3 * this.salario + Constantes.Efetivo * this.salario);
        }
        return this.salario;
    }
    
    @Override
    public String dados() {
        String dados = "Nome: " + this.nome + "\n" +
                       "Código: " + this.codigo + "\n" +
                       "Categoria: Docente Efetivo\n" +
                       "Titulação: " + this.titulacao + "\n" +
                       "Nível: " + this.nivel + "\n" +
                       "Área: " + this.area + "\n" +
                       "Salário: " + this.calcularSalario() + "\n";
        return dados;
    }
}
