package projet;

public class ZoneNotFoundException extends Exception {
    private int id;
    private int i, j;
    private String message;

    public ZoneNotFoundException(int id) {
        this.id = id;
        this.message = "La zone avec l'id " + id + " est introuvable dans l'écosystème.";
    }

    public ZoneNotFoundException(int i, int j) {
        this.i = i;
        this.j = j;
        this.message = "La zone avec les coordonnées (" + i + "," + j + ") est introuvable dans l'écosystème.";
    }

    public String toString()
    {
        return message;
    }

}
