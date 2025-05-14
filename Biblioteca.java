import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Llibre> llibres;

    public Biblioteca() {
        this.llibres = new ArrayList<>();
    }

    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public List<Llibre> getLlibres() {
        return llibres;
    }

    public void afegirLlibre(Llibre llibre) {
        for (Llibre l : llibres) {
            if (l.getTitol().equalsIgnoreCase(llibre.getTitol()) &&
                    l.getAutor().equalsIgnoreCase(llibre.getAutor())) {
                System.out.println("Aquest llibre ja existeix a la biblioteca.");
                return;
            }
        }
        llibres.add(llibre);
        System.out.println("Llibre afegit correctament: " + llibre.getTitol());
    }
}