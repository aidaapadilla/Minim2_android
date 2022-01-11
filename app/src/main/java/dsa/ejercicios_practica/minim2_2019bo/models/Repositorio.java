package dsa.ejercicios_practica.minim2_2019bo.models;

public class Repositorio {
    private String repositoryName;
    private String language;

    public Repositorio(){}

    public Repositorio(String name, String language)
    {
        this();
        setRepositoryName(name);
        setLanguage(language);
    }

    public String getLanguage() {
        return language;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }
}
