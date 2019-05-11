//TODO
//(1)create 2 個編號為N-1且不重複的random number list
//(2)輸入每個人的好友編號輸出總共有幾個群體
//ps.跳出條件為起始數字與結束數字相同

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.IntStream;

public class lab2 {

    public static ArrayList permutationIndex(int numbmer, int[] friendNumber1, int[] friendNumber2) {

        Boolean numberTag;
        int friendNumber1Value = numbmer;
        ArrayList groupResult = new ArrayList();
        groupResult.add(numbmer); // ini value
        for (int i = 0 ; i < friendNumber1.length ; i++){
//            System.out.println("i:" + i);
//            System.out.println("1: " + (friendNumber1[i] == friendNumber1Value));
            if (friendNumber1[i] == friendNumber1Value){
                //jump condition
                if (friendNumber2[i] == numbmer){
                    break;
                }
//                System.out.println("friendNumber1Index: " + friendNumber1Index);
                do {
                    numberTag = (friendNumber2[i] == friendNumber1Value);
//                    System.out.println("numberTag: " + numberTag);
                    if (!numberTag){
                        groupResult.add(friendNumber2[i]);
                        friendNumber1Value = friendNumber2[i];
//                        System.out.println("number: " + friendNumber1Value);
                        i = -1;
                    }else {
                        break;
                    }
                }while (numberTag);
            }
        }
//        System.out.println(groupResult);
        return groupResult;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int N = 16;
        int[] friendNumber1 = lab3.numberGeneratorWOR(N-1,0);
        int[] friendNumber2 = lab3.numberGeneratorWOR(N-1,0);
        lab3.shuffle(friendNumber1);
        lab3.shuffle(friendNumber2);
        lab3.showArrayElements(friendNumber1);
        lab3.showArrayElements(friendNumber2);

        //輸入每個好友編號輸出群體清單
        ArrayList groupList = new ArrayList();
        for (int member: friendNumber1){
            ArrayList result = permutationIndex(member,friendNumber1, friendNumber2);
            Collections.sort(result); // sort arrayList
            groupList.add(result);
            System.out.println(result);
        }
        System.out.println();

        //移除重複的group
        ArrayList<Integer> duplicateList = new ArrayList<Integer>();
        for (int i = 0 ; i < groupList.size(); i++){
//            System.out.println("Before groupList: " + groupList);
//            System.out.println("Before groupListSize: " + groupList.size());
            for (int j = 0; j < groupList.size(); j++){
                if (i == j ){
                    continue;
                }
                if (groupList.get(i).equals(groupList.get(j))){
                    duplicateList.add(j);
                }
            }
//            System.out.println("duplicateList: " + duplicateList);
            for (int j = 0 ; j < duplicateList.size(); j++){
                groupList.remove((duplicateList.get(j)-j));
            }
            duplicateList.clear();
//            System.out.println("After groupList: " + groupList);
//            System.out.println("After groupListSzie: " + groupList.size());
        }
        System.out.println(groupList);

        //輸出.txt
        PrintWriter outputStream = new PrintWriter("lab2.txt");
        outputStream.println(String.format("%s", Arrays.toString(friendNumber1)));
        outputStream.println(String.format("%s", "=================================================="));
        for (int i = 0; i < groupList.size(); i++){
            outputStream.println(String.format("%s %s %s %s", "Group" ,i, " :", groupList.get(i)));
            if (i == (groupList.size()-1)){
                outputStream.println(String.format("%s %s", "group number: ", groupList.size()));
            }
        }
        outputStream.close();
    }
}
