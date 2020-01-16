package lec11;

public class Player {
    private String playerName;
    private int money;
    private String[] hand;

    public Player(String playerName , String[] hand , int money){
        this.playerName = playerName;
        this.money = money;
        this.hand = hand;
    }

    public void print(){
        System.out.println("プレイヤー名:" + playerName);
        System.out.println("所持金:" + money + "$");
        System.out.println("手札:" + hand);
    }
}
