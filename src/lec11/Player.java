package lec11;

import java.util.Scanner;

public class Player {
    public String playerName;

    public Player() {
        Scanner input = new Scanner(System.in);
        System.out.println("プレイヤー名を入力してください");
        String playerName = input.next();
        this.playerName = playerName;
    }
}
