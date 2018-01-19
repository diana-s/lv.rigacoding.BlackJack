/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Diana
 */
public class Hand {
    ArrayList<Card> cards;
    
    public Hand(){
        //ja nebūtu jau augšā norādījuši ArrayList<Card>, tad te rakstītu cards=new ArrayList<Card>();
    cards = new ArrayList();
}
    public void addCard(Card card){
        cards.add(card);
        
    }
    
    public void clearCards(){
        cards.clear();
    }
    
    //mēs atgriežam kārtis, un izmantojam masīvu, jo no viņa ātrāk nolasās
    public Card[] getCards(){
        /* variants 1.
        Card[] allCards = new Card [cards.size()];
        for(i=0; i<cards.size(); i++){
        allCards[i]=cards.get[i];}
        return allCards
           */
        return cards.toArray(new Card[cards.size()]);
        
    }
    public int countPoints(){
        int total = 0;
        int aceCount = 0;
       
        for(Card card: cards){
            total+=card.getValue();
            if(card.getValueAce().equals("A")){
                aceCount++;
            }
        }
        
        //tā kā mums dūži ir jāpārbauda katru reizi, tad šoreiz izmantojam while nevis for
        while(total>21 && aceCount>0){
            //total samazinam par 10 punktiem
            total-=10;
            //ņem nost pa vienam dūzim, respektīvi, to, kura vērtību samazina, vairs neskaita par dūzi, bet par '1';
            aceCount--;
        }
        return total;
    }
    
}
