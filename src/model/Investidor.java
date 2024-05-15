package model;

/**
 * 
 * @author Manuella
 */
public class Investidor extends Usuario {
    private Carteira c1;

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.c1 = new Carteira();
    }

    public Investidor() {
        super();
        this.c1 = new Carteira();
    }

    public Carteira getC1() {
        return c1;
    }

    public void setC1(Carteira c1) {
        this.c1 = c1;
    }
}
