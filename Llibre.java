import java.util.Scanner;

public class Llibre {
    Scanner teclat = new Scanner(System.in);
private String titol;
private String autor;
private boolean prestat;

public Llibre(String titol, String autor) {
this.titol = titol;
this.autor = autor;
this.prestat = false;
}

public String getTitol() { return titol; }

public String getAutor() { return autor; }
public boolean esPrestat() { return prestat; }
public void prestar() { prestat = true; }
public void retornar() { prestat = false; }
@Override
public String toString() {
return titol + " de " + autor + (prestat ? " (En préstec)" : " (Disponible)");
}
public void crearLlibre() {
    System.out.println("Digues el titol del llibre:");
    String titol = teclat.next();
    System.out.println("Digues l'autor del llibre:");
    String autor = teclat.next();

    Llibre llibre = new Llibre(titol, autor);
    



    
}
}
