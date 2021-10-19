public class DistanceDynamic {

    static int distance (String mot, String motDictionnaire) {
        int motIndex = mot.length() - 1;
        int motDictionnaireIndex = motDictionnaire.length() - 1;
        StringBuilder motBuilder = new StringBuilder(mot);
        StringBuilder motDictionnaireBuilder = new StringBuilder(motDictionnaire);

        do{
            if (motBuilder.charAt(motIndex) == motDictionnaireBuilder.charAt(motDictionnaireIndex)){
                motIndex--;
                motDictionnaireIndex--;
            }

            else {
                /* TBLEAUX DES INDICES */
            }

        }while (Math.min(motIndex, motDictionnaireIndex) != 0);
    }
}
