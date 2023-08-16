package week2.baseballGame;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        Set<Integer> numbers = new HashSet<>();
        LinkedList<Integer> guess = new LinkedList<>();


        //컴퓨터가 숫자 생성
        while (numbers.size() < 3) {
            int randomNum = rd.nextInt(10); //0~9까지 수
            numbers.add(randomNum);
        }

        System.out.println(numbers);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int n=0;
        while(true){
            n++;
            guess.clear();//리셋
            System.out.print(n+"번째 시도 : ");

            int strike=0; String myNum = sc.nextLine();

//
            for( int i = 0; i < myNum.length(); i++) {
                int myIntNum= myNum.charAt(i)-'0'; //문자형을 정수형으로 형 변환
                guess.add(myIntNum);
            }
            int ball=0;

//           numbers인 set함수 Iterator로 반복
            Iterator <Integer>iterator = numbers.iterator();

            for(int i =0; i<guess.size();i++){
                int num = iterator.next();

                if(guess.get(i).equals(num)){ //자리와 숫자 동일한 경우
                    strike++;
                }
                else if(guess.contains(num)){ //자리는 다르지만 해당 num의 값이 guess의 list에 포함된 경우
                    ball++;
                }
            }

            if(ball>0&&strike==0){ //ball만 나온 경우
                System.out.println(ball+"B");
            }
            else if(strike>0&&ball==0){ //strike만 나온 경우
                System.out.println(strike+"S");
            }

            else{ //ball, strike 둘 다 나온 경우
                System.out.println(ball+"B"+strike+"S");
            }


            if(strike==3){
                break;
            }


        }
        System.out.println(n-1+"번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
    }
}