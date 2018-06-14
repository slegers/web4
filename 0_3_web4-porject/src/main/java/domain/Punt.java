package domain;

public class Punt {

    private String vak, naam;
    private int punt,id;

    public Punt(){
        this(0,"","",0);
    }

    public Punt(int id,String vak, String naam, int punt){

    }

    public String getVak() {
        return vak;
    }

    public void setVak(String vak) {
        this.vak = vak;
    }

    public String getNaam() {
        return naam;
    }

    public int getPunt() {
        return punt;
    }

    public int getId() {
        return id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPunt(int punt) {
        this.punt = punt;
    }

    public void setId(int id) {
        this.id = id;
    }
}
