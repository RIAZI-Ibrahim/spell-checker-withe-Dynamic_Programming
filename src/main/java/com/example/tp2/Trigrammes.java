package com.example.tp2;

import java.util.*;

public class Trigrammes {
       private HashMap<String, LinkedList<String>> trigrammesPossibles = new LinkedHashMap<>();
       public Trigrammes(List<String> dictionnaire) {
           StringBuilder mot;
           for (String motDictionnaire : dictionnaire) {
               mot = new StringBuilder(motDictionnaire);
               mot.insert(0, '<');
               mot.append('>');
               for (int i = 0; i < mot.length() - 2; i++) {
                   trigrammesPossibles.put(mot.substring(i, i + 3), null);
               }
           }
           ArrayList<LinkedList<String>> listeMot = new ArrayList<>();
           int j = 0;
           for (String trigrammeKey : trigrammesPossibles.keySet()) {
               listeMot.add(j, new LinkedList<>());
               for (String motDictionnaire : dictionnaire) {
                   mot = new StringBuilder(motDictionnaire);
                   mot.insert(0, '<');
                   mot.append('>');
                   if (mot.indexOf(trigrammeKey) != -1) {
                       listeMot.get(j).add(motDictionnaire);
                   }
               }
              // System.out.println(listeMot.get(j));
               trigrammesPossibles.put(trigrammeKey, listeMot.get(j));
               j++;
           }
          // System.out.println(trigrammesPossibles);
          // System.out.println(trigrammesPossibles.get("<ab"));

       }
       public HashMap<String, String> trigrammeMot(String mot){
           HashMap<String, String> hashTrigrammesMot = new LinkedHashMap<>();
           StringBuilder motBuilder;
               motBuilder = new StringBuilder(mot);
               motBuilder.insert(0, '<');
               motBuilder.append('>');
               for (int i = 0; i < motBuilder.length() - 2; i++) {
                   hashTrigrammesMot.put(motBuilder.substring(i, i + 3), "");
               }
               return hashTrigrammesMot;
       }

        public List<String> listeMotTrigrammesCommun (HashMap<String, String> trigrammes){
            List<String> motsTrigerammeCommun = new ArrayList<>();
            for (String trig : trigrammes.keySet()) {
                if (trigrammesPossibles.containsKey(trig)){
                    for (String mot : trigrammesPossibles.get(trig)){
                        motsTrigerammeCommun.add(mot);
                    }
                }
            }
            return motsTrigerammeCommun;
        }

        public HashMap<String, Integer> nbOccurance (List<String> mots){
           HashMap<String, Integer> listeMots = new HashMap<>();
           for (String mot : mots){
               listeMots.put(mot, Collections.frequency(mots, mot));
           }
           return listeMots;
        }

}
