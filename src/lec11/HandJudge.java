package lec11;

import java.util.*;

public class HandJudge {
    
    public HandJudge(ArrayList<Card> handList) {

        Map<Integer, Integer> count = new HashMap();

        for (int i = 0; i < handList.size(); i++) {
            int multiple = 1;
            if (count.get(handList.get(i).getNumber()) == null) {
                count.put(handList.get(i).getNumber(), multiple);
            } else {
                multiple = multiple + count.get(handList.get(i).getNumber());
                count.put(handList.get(i).getNumber(), multiple);
            }
        }

        ArrayList<Integer> mapCount = new ArrayList<>();
        for (int n : count.values()) {
            mapCount.add(n);
        }
        Collections.sort(mapCount, Comparator.reverseOrder());

        int straightFlag = 1;
        int straightCheck = handList.get(0).getNumber();
        int markFlag = 1;
        String markCheck = handList.get(0).getMark();

        for (int i = 1; i < handList.size(); i++) {
            straightCheck++;
            if (handList.get(i).getNumber() == straightCheck) {
                straightFlag++;
            }
            if (markCheck.equals(handList.get(i).getMark())) {
                markFlag++;
            }
        }

        int loyalStraight = 0;
        if (handList.get(0).getNumber() == 1 && handList.get(1).getNumber() == 10 && straightFlag == 4) {
            loyalStraight = 1;
        }

        if (loyalStraight == 1 && markFlag == 5) {
            System.out.println("ロイヤルストレートフラッシュ");
        } else if (straightFlag == 5 && markFlag == 5) {
            System.out.println("ストレートフラッシュ");
        } else if (mapCount.get(0) == 4) {
            System.out.println("フォーカード");
        } else if (mapCount.get(0) == 3 && mapCount.get(1) == 2) {
            System.out.println("フルハウス");
        } else if (markFlag == 5) {
            System.out.println("フラッシュ");
        } else if (straightFlag == 5) {
            System.out.println("ストレート");
        } else if (mapCount.get(0) == 3) {
            System.out.println("スリーカード");
        } else if (mapCount.get(0) == 2 && mapCount.get(1) == 2) {
            System.out.println("ツーペア");
        } else if (mapCount.get(0) == 2) {
            System.out.println("ワンペア");
        } else {
            System.out.println("ノーペア");
        }
    }
}
