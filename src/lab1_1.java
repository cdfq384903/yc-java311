//TODO
//(1)定義總實驗數:100000
//(2)定義勝率: navie strategy vs. binary search
//(3)定義navie strategy
//(4)定義binary search
//(5)請模擬比較隨機猜測(naive)與二元切割法(binary search)哪一個勝率比較高?

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class lab1_1 {

    public static ArrayList guessNumberSimulator(int times) throws IOException, JSONException {

        ArrayList resultList = new ArrayList();
        for (int i = 0; i <= times; i++){
            Random random = new Random();
            int gameAns = random.nextInt(99);

            JSONObject RguessNumberResult = lab1.guessNumber(gameAns, "random", false);
            JSONObject BSguessNumberResult = lab1.guessNumber(gameAns, "binarySearching", false);

            int RguessNumberResultRounds = (int) RguessNumberResult.get("rounds");
            int BSguessNumberResultRounds = (int) BSguessNumberResult.get("rounds");

            if (RguessNumberResultRounds > BSguessNumberResultRounds){
                resultList.add("binarySearch");
            }else {
                resultList.add("random");
            }

        }
        return resultList;
    }

    public static void main(String[] args) throws IOException, JSONException {
        ArrayList simulatorResult = guessNumberSimulator(100000);
        System.out.println(simulatorResult);

        //計算list element個數
        Set<String> ListCountHash = new HashSet<String>(simulatorResult);
        JSONObject CountSum = new JSONObject();
        for (String element : ListCountHash){
            System.out.println(element + ": " + Collections.frequency(simulatorResult, element));
            CountSum.put(element, Collections.frequency(simulatorResult, element));
        }

        int radomResult = (int) CountSum.get("random");
        int binarySearchResult = (int) CountSum.get("binarySearch");
        double randomRate = radomResult /100000.0;
        double binarySearchRate = binarySearchResult /100000.0;

        System.out.println("randomRate: " + randomRate);
        System.out.println("binarySearchRate: " + binarySearchRate);
    }

}
