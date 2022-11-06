package modelo;

import persistencia.DataBaseDepartamentos;

/**
 *
 * @author Igorjr19
 */

public class Universidade {
    private DataBaseDepartamentos db = new DataBaseDepartamentos();
    private String nome;
    
    public Universidade(String nome) {
        this.nome = nome;
    }

    public DataBaseDepartamentos getDb() {
        return db;
    }

    public String getNome() {
        return nome;
    }
    
    
    
    public void cadastrarFuncionario(String cod, String nome, String titfun, double salario, String nivel, String area, int carga, int dep) {
        Funcionario func;
        if(titfun.equals("Assessor") || titfun.equals("Laboratório") || titfun.equals("Secretário")) {
            func = new Tecnico(cod, nome, salario, nivel, titfun);
            this.db.getDepartamentos()[dep].adicionarFuncionario(func);
        }else if((titfun.equals("Graduação")) || (titfun.equals("Mestrado")) || (titfun.equals("Doutorado")) || (titfun.equals("Livre-Docente")) || (titfun.equals("Titular"))) {
            if(carga == 12 || carga == 24) {
                func = new Substituto(cod, nome, salario, nivel, titfun, carga);
                this.db.getDepartamentos()[dep].adicionarFuncionario(func);
            } else if(area.equals("Biológicas") || area.equals("Exatas") || area.equals("Humanas") || area.equals("Saúde")) {
                func = new Efetivo(cod, nome, salario, nivel, titfun, area);
                this.db.getDepartamentos()[dep].adicionarFuncionario(func);
            }
        }
    }
    
        
    
    public String relatorioGeral() {
        Departamento dep[] = db.getDepartamentos();
        String relatorio = "";
        int cont = 4;
        double totalSal;
        String dados;
        for(int i = 0; i < cont; i++) {
            totalSal = 0;
            dados = "";
            int nFun = dep[i].db.getNumFuncionarios();
            relatorio += "Nome do Departamento: " + dep[i].getNome() + "\n" +
                         "Código do Departemento: " + dep[i].getCodigo() + "\n";
            dados = "";
            for(int j = 0; j < nFun; j++) {
                dados += dep[i].db.getFuncionarios()[j].dados();
                dados += "\n";
                totalSal += dep[i].db.getFuncionarios()[j].calcularSalario();
            }
            relatorio += "Gasto Total com Funcionários: " + totalSal + "\n" +
                         "Dados: \n\n" + dados + "\n";
        }
        return relatorio;
    }
    
    public String buscaCodigo(String cod) {
        Departamento dep[] = db.getDepartamentos();
        int cont = 4;
        String dados = "";
        Funcionario fun;
        for(int i = 0; i < cont; i++) {
            if(dep[i].db.buscarCodigo(cod) != null) {
                fun = dep[i].db.buscarCodigo(cod);
                dados = fun.dados();
                return dados;
            }
        }
        return null;
        

    }
    
    public String buscaNome(String nome) {
        Departamento dep[] = db.getDepartamentos();
        int cont = 4;
        String dados = "";
        Funcionario fun;
        for(int i = 0; i < cont; i++) {
            if(dep[i].db.buscarNome(nome) != null) {
                fun = dep[i].db.buscarNome(nome);
                dados = fun.dados();
                return dados;
            }
        }
        return null;
    }
    
    public String resumoDepartamentos() {
        String s = "";
        for(int i = 0; i < 4; i++) {
            s += this.db.getDepartamentos()[i].resumoDepartamento();
            s += "\n";
        }
        return s;
    }
    
    public String resumoDepartamentoFaixa(double min, double max) {
        String s = "";
        double faixa;
        for(int i = 0; i < 4; i++) {
            faixa = this.getDb().getDepartamentos()[i].gastoFuncionarios();
            if(faixa <= max && faixa >= min) {
                s += this.getDb().getDepartamentos()[i].resumoDepartamento();
                s += "\n";
            }
        }
        if(s.isBlank()){
            s = "Nao há departamentos com gasto total dentro dessa faixa de valores";
        }
        return s;
    }
    
    public String exibirTodosFuncionarios() {
        String s = "";
        for(int i = 0; i < 4; i++) {
            s += db.getDepartamentos()[i].exibirTodosFuncionarios();
            s += "\n";
        }
        if(s.isBlank()){
            s = "Nao há funcionários cadastrados no sistema";
        }
        return s;
    }
    
    public String exibirFuncionariosFaixa(double min, double max) {
        String s = "";
        for(int i = 0; i < 4; i++) {
            s += this.db.getDepartamentos()[i].exibirTodosFuncionariosFaixa(min, max);
            s += "\n";
        }
        if(s.isBlank()){
            s = "Não há funcionários com sálario na faixa definida";
        }
        return s;
    }
    
    public String exibirFuncionariosTecnicos() {
        String s = "";
        for(int i = 0; i < 4; i++) {
            s += this.db.getDepartamentos()[i].exibirFuncionariosTecnicos();
            s += "\n";
        }
        if(s.isBlank()){
            s = "Não há funcionários técnicos cadastrados";
        }
        return s;
    }
    
    public String exibirFuncionariosDocentes() {
        String s = "";
        for(int i = 0; i < 4; i++) {
            s += this.db.getDepartamentos()[i].exibirFuncionariosDocentes();
            s += "\n";
        }
        if(s.isBlank()){
            s = "Não há funcionários docentes cadastrados";
        }
        return s;
    }
    
    public String exibirFuncionariosEfetivos() {
        String s = "";
        for(int i = 0; i < 4; i++) {
            s += this.db.getDepartamentos()[i].exibirFuncionariosEfetivos();
            s += "\n";
        }
        if(s.isBlank()){
            s = "Não há funcionários efetivos cadastrados";
        }
        return s;
    }
    
    public String exibirFuncionariosSubstitutos() {
        String s = "";
        for(int i = 0; i < 4; i++) {
            s += this.db.getDepartamentos()[i].exibirFuncionariosSubstitutos();
            s += "\n";
        }
        if(s.isBlank()){
            s = "Não há funcionários substitutos cadastrados";
        }
        return s;
    }
    
    public String exibirInfoDepartamento(int dep) {
        String s = "";
        s += this.db.getDepartamentos()[dep].resumoDepartamento();
        return s;
    }
}