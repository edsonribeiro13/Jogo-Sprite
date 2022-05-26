package src.modelo;

public class Personagem {

    private int chute; //1 a 25
    private int soco; //1 a 25
    private int vida; //1 a 150
    private static int overall; //3 a 100
    private String nome;

    public Personagem(){
        
    }

	public Personagem(int chute, int soco, int vida, int overall, String nome) {
        this.chute = chute;
        this.soco = soco;
        this.vida = vida;
        Personagem.overall = overall;
        this.nome = nome;
    }

    public int getChute() {
        return chute;
    }
    public void setChute(int chute) {
        this.chute = chute;
    }

    public int getsoco() {
        return soco;
    }
    public void setsoco(int soco) {
        this.soco = soco;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setOverall(int soco, int chute, int vida){
        Personagem.overall = soco + chute + vida;
    }
    public static int getOverall(){
        return overall;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
