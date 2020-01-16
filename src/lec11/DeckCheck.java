package lec11;

import java.util.Scanner;

public class DeckCheck {

    public static void main(String[]args){
        Deck deck = new Deck();
        deck.printCardList();


        try {
            Scanner input = new Scanner(System.in);
            System.out.println("どのカードを引きますか");
            int card = input.nextInt();
            Card drow = deck.drowCard(card);
            drow.print();
        }catch (IndexOutOfBoundsException e){
            System.out.println("そのカードはありません");
        }

    }
}
