// TODO
//(1)隨機產生一組數字,且範圍介於0~99
//(2)使用者隨機輸入一筆數字
//(3)顯示使用者輸入之數字範圍且更新上下界
//(4)確認使用者輸入的數字是否介於指定範圍內(輸贏)
//check 輸入大於99或小於0的數字時要警告
//check 當使用者輸入一筆比前一筆更大或更小的數字時範圍要保持不動
//check 數字重複輸入的時候upper/lower的表示不會變
//定義猜測方法a.by user b.by random c.by binary search

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class lab1 {

    public static JSONObject guessNumber(Integer gameAns, String guessMethod, Boolean export) throws JSONException, IOException {

        JSONObject resultObj = new JSONObject();
        ArrayList guessResult = null;
        int upperBound = 99;
        int lowerBound = 0;
        int rounds = 0;

        System.out.println("gameAns:" + gameAns);
        switch (guessMethod) {
            case "user":
                Scanner input = new Scanner(System.in);
                guessResult = new ArrayList();

                while (true) {
                    System.out.printf("(%d,%d) = ?\n", lowerBound, upperBound);
                    int userInput = input.nextInt();

                    guessResult.add(userInput);
                    rounds++;

                    //當使用者輸入超過上下界時迴圈從新開始執行
                    if (userInput > upperBound || userInput < lowerBound){
                        System.out.println("Out of range. Try again.");
                        continue;
                    }

                    if (userInput > gameAns) {
                        //當使用者輸入的數值大於正確解答時更新上界
                        System.out.println("Too large.");
                        upperBound = userInput - 1;
                    } else if (userInput < gameAns){
                        //當使用者輸入的數值小於正確解答時更新下界
                        System.out.println("Too small.");
                        lowerBound = userInput + 1;
                    }else {
                        //輸入正確數字時跳出迴圈
                        System.out.println("Correct.");
                        break;
                    }
                    //當上下界更新完的數值相同時跳出迴圈
                    if (upperBound == lowerBound){
                        System.out.println("GG.");
                        break;
                    }
                }
                resultObj.put("method", "user");
                break;
            case "random":
                Random random = new Random();
                guessResult = new ArrayList();

                while (true) {
                    System.out.printf("(%d,%d) = ?\n", lowerBound, upperBound);
                    int randomGuessNumber = random.nextInt(upperBound-lowerBound) + lowerBound;
                    System.out.println("randomGuessNumber: " + randomGuessNumber);

                    guessResult.add(randomGuessNumber);
                    rounds++;

                    if (randomGuessNumber > gameAns) {
                        //當系統生成的數值大於正確解答時更新上界
                        System.out.println("Too large.");
                        upperBound = randomGuessNumber - 1;
                    } else if (randomGuessNumber < gameAns){
                        //當使用者輸入的數值小於正確解答時更新下界
                        System.out.println("Too small.");
                        lowerBound = randomGuessNumber + 1;
                    }else {
                        //輸入正確數字時跳出迴圈
                        System.out.println("Correct.");
                        break;
                    }
                    //當上下界更新完的數值相同時跳出迴圈
                    if (upperBound == lowerBound){
                        System.out.println("GG.");
                        break;
                    }
                }
                resultObj.put("method", "random");
                break;
            case "binarySearching":

                guessResult = new ArrayList();

                while (true) {
                    System.out.printf("(%d,%d) = ?\n", lowerBound, upperBound);
                    int guessNumber = (((upperBound-lowerBound) + 1) / 2) + lowerBound;
                    System.out.println("guessNumber: " + guessNumber);

                    guessResult.add(guessNumber);
                    rounds++;

                    if (guessNumber > gameAns) {
                        //當系統生成的數值大於正確解答時更新上界
                        System.out.println("Too large.");
                        upperBound = guessNumber - 1;
                    } else if (guessNumber < gameAns){
                        //當使用者輸入的數值小於正確解答時更新下界
                        System.out.println("Too small.");
                        lowerBound = guessNumber + 1;
                    }else {
                        //輸入正確數字時跳出迴圈
                        System.out.println("Correct.");
                        break;
                    }
                    //當上下界更新完的數值相同時跳出迴圈
                    if (upperBound == lowerBound){
                        System.out.println("GG.");
                        break;
                    }
                }
                resultObj.put("method", "binarySearching");
                break;

        }
        System.out.println("guessResult: " + guessResult);
        System.out.println("rounds: " + rounds);

        /*
        result to json object
         */
        resultObj.put("gameAns", gameAns);
        resultObj.put("guessResult", guessResult);
        resultObj.put("rounds", rounds);

        /*
        result export to .json
         */
        if (export == true){
            Writer write = new OutputStreamWriter(new FileOutputStream("lab01.json"), "UTF-8");
            write.write(resultObj.toString());
            write.flush();
            write.close();
        }

        return resultObj;
    }

    public static void main(String[] args) throws IOException, JSONException {
        Random random = new Random();
        int gameAns = random.nextInt(99);
//        int randomValue = (int) (Math.random() * 10);
//        int randomValue1 = random.nextInt(99);
//        System.out.println(randomValue);
//        System.out.println(randomValue1);

        JSONObject guessNumberResult = guessNumber(gameAns, "binarySearching", false);
        System.out.println("guessNumberResult:" + guessNumberResult);
    }

}
