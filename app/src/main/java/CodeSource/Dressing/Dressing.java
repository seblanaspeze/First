package CodeSource.Dressing;


import java.util.ArrayList;

import CodeSource.Vetement.Vetement;

/**
 * Created by Lanas on 02/05/2016.
 */
public class Dressing {

    private ArrayList<Vetement> dressing;
    private ArrayList<String> col;

    public Dressing(){
        dressing = new ArrayList<Vetement>();
        col = new ArrayList<>();
    }

    public Dressing (ArrayList<Vetement> dressing, ArrayList<String> col){
        this.dressing = dressing;
        this.col = col;
    }

    public void add(Vetement vetement){
        dressing.add(vetement);
        String col1 = vetement.getCol1();
        String col2 = vetement.getCol2();
        String col3 = vetement.getCol3();
        boolean C1 = false; boolean C2 = false; boolean C3 = false;
        int s = col.size();

        for(int i = 0; i < s; i ++){

           if(col.get(i).compareTo(col1) == 0){
               C1 = true;
           }
           if(col.get(i).compareTo(col2) == 0){
                C2 = true;
           }
           if(col.get(i).compareTo(col3) == 0){
                C3 = true;
           }
        }

        if(C1){
            col.add(col1);
        }
        if(C2){
            col.add(col2);
        }
        if(C3){
            col.add(col3);
        }
    }

    public ArrayList<Vetement> trieType(char type){

        int s = dressing.size();
        ArrayList<Vetement> trie = new ArrayList<Vetement>();
        char c = ' ';

        for (int i = 0; i < s; i++){
            c = dressing.get(i).getType();
            if (c == 'T'){

                trie.add(dressing.get(i));

            }
        }

        return trie;
    }

    public ArrayList<Vetement> triecol1(String col1){

        int s = dressing.size();

        ArrayList<Vetement> trie = new ArrayList<Vetement>();
        String c = "";

        for (int i = 0; i < s; i++){
            c = dressing.get(i).getCol1();
            if (c.compareTo(col1)== 0){

                trie.add(dressing.get(i));

            }
        }

        return trie;
    }

    public ArrayList<Vetement> triecol2(String col1){

        int s = dressing.size();

        ArrayList<Vetement> trie = new ArrayList<Vetement>();
        String c = "";

        for (int i = 0; i < s; i++){
            c = dressing.get(i).getCol2();
            if (c.compareTo(col1)== 0){

                trie.add(dressing.get(i));

            }
        }

        return trie;
    }

    public ArrayList<Vetement> triecol3(String col1){

        int s = dressing.size();

        ArrayList<Vetement> trie = new ArrayList<Vetement>();
        String c = "";

        for (int i = 0; i < s; i++){
            c = dressing.get(i).getCol3();
            if (c.compareTo(col1)== 0){

                trie.add(dressing.get(i));

            }
        }

        return trie;
    }

    public ArrayList<Vetement> trieFavori(){

        int s = dressing.size();
        ArrayList<Vetement> trie = new ArrayList<Vetement>();
        boolean c = false;

        for (int i = 0; i < s; i++){
            c = dressing.get(i).isFavori();
            if ( c ){

                trie.add(dressing.get(i));

            }
        }

        return trie;
    }
    public ArrayList<Vetement> trieLarge(String col1, String col2, String col3, char type, boolean favori){

        ArrayList<Vetement> trie = new ArrayList<Vetement>();
        if (col1.compareTo("") != 0){
            trie.addAll(this.triecol1(col1));
            trie.addAll(this.triecol1(col2));
            trie.addAll(this.triecol1(col3));
        }
        if (col2.compareTo("") != 0){
            trie.addAll(this.triecol1(col1));
            trie.addAll(this.triecol1(col2));
            trie.addAll(this.triecol1(col3));
        }
        if (col3.compareTo("") != 0){
            trie.addAll(this.triecol1(col1));
            trie.addAll(this.triecol1(col2));
            trie.addAll(this.triecol1(col3));
        }
        if (type != ' '){
            trie.addAll(this.trieType(type));
        }
        if(favori){
            trie.addAll(this.trieFavori());
        }


        return trie;
    }


}
