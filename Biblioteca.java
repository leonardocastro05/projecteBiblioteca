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

    public Llibre buscarLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equalsIgnoreCase(titol)) {
                return llibre;
            }
        }
        return null;
    }

    public List<Llibre> getLlibres() {
        return llibres;
    }

    // Nou mètode per llistar llibres
    public void llistarLlibres() {
        if (llibres.isEmpty()) {
            System.out.println("No hi ha llibres a la biblioteca.");
        } else {
            System.out.println("Llibres disponibles a la biblioteca:");
            for (Llibre llibre : llibres) {
                System.out.println("- " + llibre);
            }
        }
    }
}
