/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Diana
 */
public class Player implements Participant {
    //private nozīmē, ka pieeja Hand būs tikai Player klasei, bet Dealer nebūs
    /*protected nozīmē, ka pieeja hand ir arī mantotām klasēm 
    (ar extended pie Dealer klases, norādijām, ka tā manto visu, kas ir šai klasē*/
    protected Hand hand;
    public Player(){
        hand = new Hand();
    }

    @Override
    public void giveCard(Card card) {
        System.out.println("Spēlētajs saņem kārti "+card.getFullName());
        hand.addCard(card);
    }

    @Override
    public Card[] getCards() {
        return hand.getCards();
    }

    @Override
    public int getTotalPoints() {
        return hand.countPoints();
    }

    public boolean isInGame() {
        System.out.println("Tev ir "+getTotalPoints()+" punkti.");
        
        if(getTotalPoints()>21){
            return false;
        }
        return Game.getAnswer("Vai ir nepieciešama vēl kārts(y/n)?: ");
    }
    public void removeCards(){
        hand.clearCards();
    }
}
