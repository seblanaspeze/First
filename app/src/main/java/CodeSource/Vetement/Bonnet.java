package CodeSource.Vetement;

/**
 * Created by Lanas on 02/05/2016.
 */
public class Bonnet extends Vetement {
    public Bonnet() {
        this.setType('B');
    }

    public Bonnet(String nom, String col1, String col2, String col3, boolean favori, String pathName) {
        super(nom, 'B', col1, col2, col3, favori, pathName);
    }
}
