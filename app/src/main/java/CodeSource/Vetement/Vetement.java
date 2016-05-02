package CodeSource.Vetement;

/**
 * Created by Lanas on 02/05/2016.
 */
public class Vetement {

    private String nom;
    private char type;
    private String col1;
    private String col2;
    private String col3;
    private boolean favori;
    private String pathName;

    //Constructeur

    public Vetement(){
        nom ="";
        type = ' ';
        col1 = "";
        col2 = "";
        col3 = "";
        favori = false;
    }

    public Vetement(String nom, char type, String col1, String col2, String col3, boolean favori, String pathName){

        this.nom = nom;
        this.type = type;
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.favori = favori;
        this.pathName = pathName;

    }


    // Setteur

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public void setCol3(String col3) {
        this.col3 = col3;
    }

    public void setFavori(boolean favori) {
        this.favori = favori;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    //Geteur

    public String getNom() {
        return nom;
    }

    public char getType() {
        return type;
    }

    public String getCol1() {
        return col1;
    }

    public String getCol2() {
        return col2;
    }

    public String getCol3() {
        return col3;
    }

    public boolean isFavori() {
        return favori;
    }

    public String getPathName() {
        return pathName;
    }
}
