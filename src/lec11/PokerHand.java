package lec11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class PokerHand extends Player{
    Deck deck = new Deck();
    private ArrayList<Card> handList = new ArrayList<>();

    public PokerHand() {
        System.out.println(playerName + "の手札");
        for (int i = 0; i < 5; i++) {
            Card drow = deck.drowCard(0);
            handList.add(drow);
        }
        handListPrint();

        Scanner input = new Scanner(System.in);
        System.out.println("何番目のカードを捨てるか入力してください(捨てない場合は0)　例:3,4,5");
        String card = input.next();
        System.out.println(playerName + "の交換後の手札");
        String changeCard[] = card.split(",");
        try {
            if (parseInt(changeCard[0]) != 0){
                for (int i = changeCard.length; i > 0; i--) {
                    int removeCard = parseInt(changeCard[i - 1]) - 1;
                    handList.remove(removeCard);
                }
                for (int i = 0; i < changeCard.length; i++) {
                    Card drow = deck.drowCard(0);
                    handList.add(drow);
                }
            }
        }catch (Exception e){
            System.out.println("例外が発生しました、システムを終了します");
            return;
        }
        handListPrint();
        new HandJudge(handList);
    }

    public void handListPrint(){
        handList.sort(Comparator.comparing(Card::getNumber));
        for (int i = 0; i < 5; i++) {
            Card hand = handList.get(i);
            hand.print();
        }
    }
}

