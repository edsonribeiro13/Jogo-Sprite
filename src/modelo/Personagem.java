package src.modelo;

public class Personagem {

    private int power; //1 a 25
    private int dash; //1 a 25
    private int mana; //1 a 25
    private int vida; //1 a 25
    private int overall; //4 a 100
    private String nome;

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public int getDash() {
        return dash;
    }
    public void setDash(int dash) {
        this.dash = dash;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setOverall(int dash, int mana, int power, int vida){
        this.overall = dash + mana + power + vida;
    }
    public int getOverall(){
        return overall;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
