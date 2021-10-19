public class Distance {
      static int distance (String mot, String motDictionnaire){
            int motIndex = mot.length()-1;
            int motDictionnaireIndex = motDictionnaire.length()-1;
            StringBuilder motBuilder = new StringBuilder(mot);
            StringBuilder motDictionnaireBuilder = new StringBuilder(motDictionnaire);


            if (Math.min(motBuilder.length(), motDictionnaireBuilder.length()) == 0){
                  return Math.max(motBuilder.length(), motDictionnaireBuilder.length());
            }

            else if(motBuilder.charAt(motIndex) == motDictionnaireBuilder.charAt(motDictionnaireIndex)) {

                  return distance(motBuilder.deleteCharAt(motIndex).toString(),
                          motDictionnaireBuilder.deleteCharAt(motDictionnaireIndex).toString());

            }
            else {
                  return 1 + Math.min(
                          distance(motBuilder.deleteCharAt(motIndex).toString(), motDictionnaireBuilder.toString()),
                          Math.min(
                                  distance(motBuilder.toString(), motDictionnaireBuilder.deleteCharAt(motDictionnaireIndex).toString()),
                                  distance(motBuilder.deleteCharAt(motIndex).toString(),
                                          motDictionnaireBuilder.deleteCharAt(motDictionnaireIndex).toString())
                          )
                  );
            }
      }

}
