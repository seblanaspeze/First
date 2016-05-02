package CodeSource.Dressing;

import CodeSource.Vetement.Casquette;
import CodeSource.Vetement.TShirt;
import CodeSource.Vetement.Bonnet;

/**
 * Created by Lanas on 02/05/2016.
 */
public class ScenarioSem3 {

    public static Dressing senario(){

        Dressing dressing = new Dressing();

        TShirt T1 = new TShirt("T-shirt1","rouge","","",true,"");
        TShirt T2 = new TShirt("T-shirt2","noir","vert","",false,"");
        Casquette C1 = new Casquette("Casquette1","jaune","noir","",false,"");
        Casquette C2 = new Casquette("Casquette2","bleu","","",true,"");
        Bonnet B1 = new Bonnet("Bonnet1","bleu","rouge","",false,"");
        Bonnet B2 = new Bonnet("Bonnet2","orange","bleu","",false,"");

        dressing.add(T1);
        dressing.add(T2);
        dressing.add(C1);
        dressing.add(C2);
        dressing.add(B1);
        dressing.add(B2);



        return dressing;
    }
}
