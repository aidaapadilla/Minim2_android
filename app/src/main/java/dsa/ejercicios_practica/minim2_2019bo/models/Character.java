package dsa.ejercicios_practica.minim2_2019bo.models;

import java.util.LinkedList;
import java.util.List;

import dsa.ejercicios_practica.minim2_2019bo.models.Medalla;

public class Character {
    private String nickname;
    private String name;
    private String avatar;
    LinkedList<Medalla> medallas;

    public Character(){}
    public Character(String nickname, String name)
    {
        setNickname(nickname);
        setName(name);
    }
    public void setNickname(String nickname){this.nickname = nickname;}
    public String getNickname(){return nickname;}

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void addMedal(Medalla medalla)
    {
        medallas.add(medalla);
    }
    public LinkedList<Medalla> getMedallasCharacter(){return medallas;}
    public void addMedallas(LinkedList<Medalla> medallas)
    {
        this.medallas = medallas;
    }

}
