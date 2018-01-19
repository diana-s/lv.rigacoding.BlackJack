/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;

/**
 *
 * @author Diana
 */
public class Game {

    private Dealer dealer;
    private Player player;
    
    private Deck deck;
    
    private static Scanner input = new Scanner(System.in);
    
    public Game(){
        dealer = new Dealer();
        player = new Player();
        deck = new Deck();
    }
    //tā kā mēs nosaucām pašu funkciju public boolean getAnswer, tas pats ar sevi nozīmē, ka funkcija izpildās tikai pie TRUE
    public static boolean getAnswer(String question){
        System.out.print(question);
         char value = input.next().charAt(0);
    value = Character.toLowerCase(value);
    //pārbauda vai lietotājs ir uzrakstījis Y
    //ja būs 'y', tad ir true un viņš turpina nākamo funkciju
    //ja būs 'n', tad tas ir false
        //1.variants īsais:   return value =='y';
    //2.variants:
    if(value =='y'){
        return true;
    }
    else{
        return false;
    }
    }
    
    public boolean startNewGame(){
    boolean startNew = getAnswer("Vai uzsākt jaunu spēli (Y/N)?: ");
   
    
    if(startNew){
        //samaisam kārtis
        //katrai spēlei ņem jaunu kāršu kavu!
        deck=new Deck();
        deck.shuffle();
        
        //pirms katras jaunas spēles notīrās iepriekšējās kārtis
        player.removeCards();
        dealer.removeCards();
        
        //spēlētājam iedosim kārti
        //izveidojām funkciju player klasē, to izmantojam šeit, lai iedotu kārti
        //kārti paņem no deck, kur izveidojām funkciju takeCard
        //spēlētājs spēli sāk ar 2 kartīm
        player.giveCard(deck.takeCard());
        player.giveCard(deck.takeCard());
        
        dealer.giveCard(deck.takeCard());
        dealer.giveCard(deck.takeCard());
        
        while(player.isInGame()){
            player.giveCard(deck.takeCard());
        }
        while(dealer.isInGame()){
            dealer.giveCard(deck.takeCard());
        }
        getResults();
    }
    return startNew;
}
    private void getResults(){
        int PlayerPoint = player.getTotalPoints();
        int DealerPoint = dealer.getTotalPoints();
        
        System.out.println("Tev ir: "+PlayerPoint+" punkti.");
        System.out.println("Dīlerim ir: "+DealerPoint+" punkti.");
    
        if(PlayerPoint>21 && DealerPoint>21){
            System.out.println("Neviens nav uzvarējis");
        }
        else if(PlayerPoint>21){
            System.out.println("Dīleris ir uzvarējis!");
        }
         else if(DealerPoint>21){
            System.out.println("Tu esi uzvarējis!");
        }
         else if (PlayerPoint==DealerPoint){
             System.out.println("Neviens nav uzvarējis");
         }
         else if(PlayerPoint>DealerPoint){
             System.out.println("Tu esi uzvarējis!");
         }
         else{
             System.out.println("Dīleris ir uzvarējis!");
         }
    }
}
