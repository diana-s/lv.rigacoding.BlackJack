/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Diana
 */
public class Dealer extends Player {
public Dealer(){
    /*Dealer konstruktors izsauc augstāk minētās klases metodes. 
    To var izsaukt ar super, jo pie klases norādijām, ka Dealer klase pārņem Player klases saturu 
    (....class Dealer extends Player    
    */ 
    super();
}    
//darīs visu to pašu, ko spēlētājam, izņemot zemāk uzrakstīto funkciju, jo uzrakstijām, ka @override - pārrakstām šo funkciju šai klasei savādaku
@Override
public void giveCard(Card card){
    System.out.println("Dīleris saņēma kārti ");
    hand.addCard(card);
}
@Override
public boolean isInGame(){
    int max = ThreadLocalRandom.current().nextInt(16, 20);
   return hand.countPoints()<max;
// return hand.countPoints()<17;y
}
}
