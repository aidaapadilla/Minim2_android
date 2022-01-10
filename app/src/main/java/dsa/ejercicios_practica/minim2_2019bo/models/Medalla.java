package dsa.ejercicios_practica.minim2_2019bo.models;

public class Medalla {
    private String name;
    private String linkPhoto;

    public Medalla(){}

    public Medalla(String name, String linkPhoto)
    {
        this();
        setName(name);
        setLink(linkPhoto);
    }
    public void setName(String name){ this.name = name;}
    public String getName(){return name;}

    public void setLink(String linkPhoto){this.linkPhoto = linkPhoto;}
    public String getLink(){return linkPhoto;}
}
