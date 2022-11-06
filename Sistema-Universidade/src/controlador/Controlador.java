package controlador;

import modelo.Docente;
import modelo.Efetivo;
import modelo.Funcionario;
import modelo.Substituto;
import modelo.Tecnico;
import modelo.Universidade;

/**
 *
 * @author Igorjr19
 */

public class Controlador {
    private Universidade universidade = new Universidade("Faculdade de Presidente Prudente");
    
    public String getNome() {
        return this.universidade.getNome();
    }
    
    public void cadastrarFuncionario(Funcionario fun, int dep) {
        String cod = fun.getCodigo();
        String nome = fun.getNome();
        double salario = fun.getSalario();
        String nivel = fun.getNivel();
        String titfun;
        String area;
        int carga;
        if(fun instanceof Tecnico) {
            titfun = ((Tecnico) fun).getFuncao();
            area = "";
            carga = 0;
        } else if(fun instanceof Substituto){
            titfun = ((Substituto) fun).getTitulacao();
            carga = ((Substituto) fun).getCargaHoraria();
            area = "";
        }else if(fun instanceof Efetivo){
            titfun = ((Efetivo) fun).getTitulacao();
            area = ((Efetivo) fun).getArea();
            carga = 0;
        } else {
            titfun = "";
            area = "";
            carga = 0;            
        }
        universidade.cadastrarFuncionario(cod, nome, titfun, salario, nivel, area, carga, dep);
    }
    
    public String buscaFuncionarioCod(String cod) {
        String s;
        s = universidade.buscaCodigo(cod);
        return s;
    }
    
    public String buscaFuncionarioNome(String nome) {
        String s;
        s = universidade.buscaNome(nome);
        return s;
    }
    
    public String relatorioGeral() {
        String s;
        s = universidade.relatorioGeral();
        return s;
    }
    
    public String resumoDepartamentos() {
        String s;
        s = universidade.resumoDepartamentos();
        return s;
    }
    
    public String resumoDepartamentosFaixa(double min, double max) {
        String s;
        s = universidade.resumoDepartamentoFaixa(min, max);
        return s;
    }
    
    public String exibirFuncionariosFaixa(double min, double max) {
        String s;
        s = universidade.exibirFuncionariosFaixa(min, max);
        return s;
    }
    
    public String exibirTodosFuncionarios() {
        String s;
        s = universidade.exibirTodosFuncionarios();
        return s;
    }
    
    public String exibirFuncionariosTecnicos() {
        String s;
        s = universidade.exibirFuncionariosTecnicos();
        return s;
    }
    
    public String exibirFuncionariosDocentes() {
        String s;
        s = universidade.exibirFuncionariosDocentes();
        return s;
    }
    
    public String exibirFuncionariosSubstitutos() {
        String s;
        s = universidade.exibirFuncionariosSubstitutos();
        return s;
    }
    
    public String exibirFuncionariosEfetivos() {
        String s;
        s = universidade.exibirFuncionariosEfetivos();
        return s;
    }
    
    public String exibirInfoDepartamento(int dep) {
        String s;
        s = universidade.exibirInfoDepartamento(dep);
        return s;
    }
}

