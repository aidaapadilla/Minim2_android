package dsa.ejercicios_practica.minim2_2019bo.models;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String name;
    private int followers;
    private int following;
    private String link;
    List<Repositorio> repositorios;

    public User(){}
    public User(String name, int followers, int following,String link, List<Repositorio> repositorios)
    {
        this();
        setName(name);
        setFollowers(followers);
        setFollowing(following);
        setLink(link);
        setRepositorios(repositorios);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public List<Repositorio> getRepositorios() {
        return repositorios;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public void setRepositorios(List<Repositorio> repositorios) {
        this.repositorios = repositorios;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
