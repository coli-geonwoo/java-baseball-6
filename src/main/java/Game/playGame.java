package Game;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class playGame {
    String answer = new String();

    public playGame(){
        while(answer.length()<3){
            int randomNum= Randoms.pickNumberInRange(1,9);
            if(!answer.contains(String.valueOf(randomNum))){
                answer+=String.valueOf(randomNum);
            }
        }
    }

    private void turn(){
        String inputString;
        do {
            System.out.print("숫자를 입력해주세요 :");
            inputString = Console.readLine();
            checkInputString(inputString);
        }while(checkGameResult(inputString)==true);
    }

    private void checkInputString(String inputString)
    {
        String tmp="";
        if (inputString.length() !=3)
        {   //예외처리 : 문자열 길이 판단
            throw new IllegalArgumentException("잘못된 길이의 문자를 입력하셨습니다.");
        }
        for(char c: inputString.toCharArray()) {
            //예외처리 : 음수 입력 및 문자입력
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("잘못된 타입의 문자를 입력하셨습니다.");
            }
            // 예외처리 : 중복된 숫자 입력
            if(tmp.contains(String.valueOf(c))){
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다");
            }
            tmp+=String.valueOf(c);

        }
    }

    private int cntStrike(String inputNumber){
        int strike_cnt = 0;
        for (int i = 0; i<answer.length(); i++) {
            if(inputNumber.charAt(i) == answer.charAt(i)){
                strike_cnt++;
            }
        }
        return strike_cnt;
    }
    private int cntTotal(String inputString){
        int total_cnt = 0;
        for (char c : inputString.toCharArray()) {
            if(answer.contains(c+"")){
                total_cnt++;
            }
        }
        return total_cnt;
    }

    private boolean checkGameResult(String inputNumberString){
        int strike_cnt = cntStrike(inputNumberString);
        int total_cnt = cntTotal(inputNumberString);

        if(strike_cnt == 3){
            return true;
        }
        else{
            return false;
        }
    }
}
