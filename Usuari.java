import java.util.ArrayList;
import java.util.List;

public class Usuari {
    private String nom;
    private List<Llibre> llibresPrestats;
    private boolean eliminat;

    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
        this.eliminat = false;
    }

    public String getNom() {
        return nom;
    }

    public List<Llibre> getLlibresPrestats() {
        return llibresPrestats;
    }

    public void afegirLlibre(Llibre llibre) {
        llibresPrestats.add(llibre);
    }

    public void retornarLlibre(Llibre llibre) {
        llibresPrestats.remove(llibre);
    }

    public void modificarNom(String nouNom) {
        this.nom = nouNom;
    }

    public void eliminarUsuari() {
        for (Llibre llibre : llibresPrestats) {
            llibre.retornar();
        }
        llibresPrestats.clear();
        this.eliminat = true;
        System.out.println("Usuari eliminat: " + nom + ". Tots els llibres han estat retornats.");
    }

    public boolean estaEliminat() {
        return eliminat;
    }

    public String toString() {
        return eliminat ? "[ELIMINAT]" : "Usuari: " + nom;
    }
}
