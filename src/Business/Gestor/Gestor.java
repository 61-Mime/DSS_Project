/**
 * Classe que representa um Gestor
 */

package Business.Gestor;

public class Gestor {
    private int idGestor;
    private String nome;
    private String password;
    private boolean online;

    public Gestor(int id, String nome, String password, boolean online) {
        this.idGestor = id;
        this.nome = nome;
        this.password = password;
        this.online = online;
    }

    /**
     * Devolve o ID do Gestor
     *
     * @return ID do Gestor
     */
    public int getIdGestor() {
        return idGestor;
    }

    /**
     * Altera o ID do Gestor
     *
     * @param idGestor novo ID do Gestor
     */
    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }

    /**
     * Devolve o nome do Gestor
     *
     * @return Nome do Gestor
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do Gestor
     *
     * @param nome novo nome do Gestor
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve a password do Gestor
     *
     * @return Password do Gestor
     */
    public String getPassword() {
        return password;
    }

    /**
     * Ãltera a password do Gestor
     *
     * @param password nova password do Gestor
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Verififca se o Gestor está online
     *
     * @return Booleano que respresenta se o Gestor está online ou não
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * Altera o estado de conexão do Gestor
     *
     * @param online novo estado de conexão de Gestor
     */
    public void setOnline(boolean online) {
        this.online = online;
    }

    /**
     * Valida as credenciais do Gestor
     *
     * @param password possível password do Gestor
     * @return validação das credenciais através d e um boolean
     */
    public boolean validaCredenciaisGestor(String password) {
        System.out.println(this.password);
        return (this.password.equals(password));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gestor gestor = (Gestor) o;
        return online == gestor.online && nome.equals(gestor.nome) && password.equals(gestor.password);
    }
}
