package CodeSource.Vetement;

/**
 * Created by Lanas on 02/05/2016.
 */
public class TShirt extends Vetement{

    public TShirt() {
        this.setType('T');
    }

    public TShirt(String nom, String col1, String col2, String col3, boolean favori, String pathName) {
        super(nom, 'T', col1, col2, col3, favori, pathName);

    }
}
