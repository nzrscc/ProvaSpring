package it.dto;

import java.util.Comparator;

public class UserDTO implements Comparable<UserDTO> {
    private  int id;
    private String nome;
    private String punteggio; //definito in percentuale : tentativi corretti x 100 / tentativi totali dell'utente

    public UserDTO()  {}

    public UserDTO(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public UserDTO(int id, String nome, String punteggio) {
        this.id = id;
        this.nome = nome;
        this.punteggio = punteggio;
    }

    @Override
    public String toString() {
        return id+ ","+ nome + "," + punteggio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(String punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public int compareTo(UserDTO user ) {
        int a = Integer.parseInt(this.punteggio);
        int b = Integer.parseInt(user.punteggio);
        int cmp = a > b ? -1 : a < b ? +1 : 0;
        return cmp;
    }
}
