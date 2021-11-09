public class DistanceDynamic {

    static Long distance (String mot, String motDictionnaire) {
        int i,j;
        StringBuilder motLigne = new StringBuilder(mot);
        StringBuilder motcolonne = new StringBuilder(motDictionnaire);
        int nbLigne = motLigne.length()+1;
        int nbColonne = motcolonne.length()+1;
        Long[][] matriceDistance = new Long [nbLigne][nbColonne];
       // System.out.println(motLigne.length);
        motLigne.insert(0,'0');
        motcolonne.insert(0,'0');
        //boolean per = false;
        for(i = 0; i <= mot.length(); i++){
            for (j = 0; j <= motDictionnaire.length(); j++){
                if (i == 0 && j == 0) matriceDistance[0][0] = 0L;
                else if (i == 0 && j != 0) matriceDistance[i][j] = matriceDistance[i][j-1]+1;
                else if (j == 0 && i != 0) matriceDistance[i][j] = matriceDistance[i-1][j]+1;
                else {
                   /* if (j < motDictionnaire.length() && i < mot.length() && motLigne.charAt(i) != motcolonne.charAt(j) && motLigne.charAt(i) == motcolonne.charAt(j+1) && motLigne.charAt(i+1) == motcolonne.charAt(j)){
                        matriceDistance[i][j] = matriceDistance[i-1][j-1]+0;
                        per = true;
                        && !per // Dans la condition suivante.
                    }*/
                    if (motLigne.charAt(i) != motcolonne.charAt(j))
                        matriceDistance[i][j] = Math.min(matriceDistance[i-1][j-1]+1, Math.min(matriceDistance[i][j-1]+1, matriceDistance[i-1][j]+1));
                    else matriceDistance[i][j] = matriceDistance[i - 1][j - 1] + 0;

                }
               // per = false;
            }
        }

        return matriceDistance[mot.length()][motDictionnaire.length()];
    }
}
