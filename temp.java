import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class temp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        GestorBiblioteca gestor = new GestorBiblioteca();
        List<Usuari> usuaris = new ArrayList<>();

        boolean sortir = false;

        while (!sortir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Afegir usuari");
            System.out.println("2. Modificar usuari");
            System.out.println("3. Eliminar usuari");
            System.out.println("4. Afegir llibre");
            System.out.println("5. Prestar llibre");
            System.out.println("6. Sortir");
            System.out.print("Opció: ");
            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    System.out.print("Nom de l’usuari: ");
                    String nomNou = scanner.nextLine();
                    usuaris.add(new Usuari(nomNou));
                    System.out.println("Usuari afegit.");
                    break;

                case 2:
                    System.out.print("Nom actual de l’usuari: ");
                    String nomActual = scanner.nextLine();
                    Usuari usuariMod = trobarUsuari(usuaris, nomActual);
                    if (usuariMod != null) {
                        System.out.print("Nou nom: ");
                        String nouNom = scanner.nextLine();
                        usuariMod.modificarNom(nouNom);
                        System.out.println("Nom modificat.");
                    } else {
                        System.out.println("Usuari no trobat.");
                    }
                    break;

                case 3:
                    System.out.print("Nom de l’usuari a eliminar: ");
                    String nomEliminar = scanner.nextLine();
                    Usuari usuariElim = trobarUsuari(usuaris, nomEliminar);
                    if (usuariElim != null) {
                        usuariElim.eliminarUsuari();
                    } else {
                        System.out.println("Usuari no trobat.");
                    }
                    break;

                case 4:
                    System.out.print("Títol del llibre: ");
                    String titol = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    Llibre llibre = new Llibre(titol, autor);
                    biblioteca.afegirLlibre(llibre);
                    System.out.println("Llibre afegit a la biblioteca.");
                    break;

                case 5:
                    System.out.print("Nom de l’usuari: ");
                    String nomPrestec = scanner.nextLine();
                    Usuari usuariPrestec = trobarUsuari(usuaris, nomPrestec);
                    if (usuariPrestec == null || usuariPrestec.estaEliminat()) {
                        System.out.println("Usuari no trobat o eliminat.");
                        break;
                    }

                    if (!Prestec.potDemanarMesLlibres(usuariPrestec)) {
                        System.out.println("L’usuari ha assolit el límit de llibres prestats.");
                        break;
                    }

                    System.out.print("Títol del llibre a prestar: ");
                    String titolPrestec = scanner.nextLine();
                    Llibre llibrePrestec = biblioteca.buscarLlibre(titolPrestec);
                    if (llibrePrestec != null) {
                        gestor.prestarLlibre(usuariPrestec, llibrePrestec);
                    } else {
                        System.out.println("Llibre no trobat.");
                    }
                    break;

                case 6:
                    sortir = true;
                    System.out.println("Sortint...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }
        }

        scanner.close();
    }

    // Funció auxiliar per buscar un usuari per nom
    private static Usuari trobarUsuari(List<Usuari> usuaris, String nom) {
        for (Usuari u : usuaris) {
            if (u.getNom().equalsIgnoreCase(nom)) {
                return u;
            }
        }
        return null;
    }
}