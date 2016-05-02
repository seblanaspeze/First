package CodeSource.Vetement;

/**
 * Created by Lanas on 02/05/2016.
 */
public class Casquette extends Vetement {

    public Casquette() {
        this.setType('C');
    }

    public Casquette(String nom, String col1, String col2, String col3, boolean favori, String pathName) {
        super(nom, 'C', col1, col2, col3, favori, pathName);
    }
}
