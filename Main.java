// 정환님
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

// 우응
package Q;

import java.util.Scanner; //입력받기 위한 라이브러리
import java.util.Random;

public class baseball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 사용자 입력 받기
        Random random = new Random(); // 랜덤으로 숫자 생성하기
        int [] targetNumbers = new int[3]; // 3자리의 배열생성
        for (int i = 0; i < 3; i++) {
            targetNumbers[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (targetNumbers[i] == targetNumbers[j]) {
                    i--;
                    break;
                }
            }
        }

        System.out.println("야구 게임을 시작합니다!");
        int attempts = 0; // 게임 시도 횟수 세기
        while (true) { //게임 루프
            System.out.print("세 개의 숫자를 입력하세요 (1부터 9까지, 공백으로 구분): "); // 게임시작 설명해주기
            int[] userGuess = new int[3]; // 사용자가 배열 3개를 추측
            String num = scanner.nextLine(); //123
            for (int i = 0; i < 3; i++) { // 3자리 배열의 조건걸기
                int a = num.charAt(i) - '0';   // '1'=>49  '0'=>48
                userGuess[i] =  a;
            }
            int strikes = 0; // 스트라이크 개수 초기화
            int balls = 0; // 볼 개수 초기화
            for (int i = 0; i < 3; i++) {
                if (userGuess[i] == targetNumbers[i]) {
                    strikes++; // 같은 위치에 같은 숫자가 있으면 스트라이크 증가
                } else if (contains(targetNumbers, userGuess[i])) {
                    balls++; // 다른 위치에 같은 숫자가 있으면 볼 증가
                }
            }
            System.out.println("결과: " + strikes + " 스트라이크, " + balls + " 볼");
            if (strikes == 3) {
                System.out.println("축하합니다! 정답을 맞추셨습니다!");
                break;
            }
            attempts++;
        }

        System.out.println("게임 종료. 총 " + attempts + "번 시도하셨습니다.");
        scanner.close();
    }

    public static boolean contains(int[] array, int value) {
        for(int i = 0; i<array.length;i++){
            if(array[i]==value){
                return true;
            }

        }
        return false;
    }
}


// 재익

import java.util.*;

public class NumberBaseball {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int[] num = new int[3];
        int[] input = new int[3];
        int S = 0;
        int B = 0;

        for(int i=0; i<num.length; i++) {
            num[i] =(int)(Math.random()*9 + 1); //Math.random() : 0~1 난수를 생성
            for(int j=0; j<i; j++) {
                if(num[j]==num[i]) {
                    i--;
                    break;
                }
            }
        }
        // 랜덤 수 확인
        for(int item : num) {
            System.out.print(item + " ");
        }

        System.out.println();

        int a = 1;
        while(S<3) {
            S = 0;
            B = 0;
            System.out.println(a + "번째 시도 : ");

            int number = sc.nextInt(); // 123
            input[0] = number / 100; // 1
            input[1] = (number % 100)/10; // 2
            input[2] = number % 10; // 3


            for(int i=0; i<num.length; i++) {
                if(num[i]==input[i]) {
                    S++;
                } else if (contains(num, input[i])) {
                    B++;
                }
            }
            if(S==3) {
                System.out.println("3S");
            } else {
                a++;
                if(B==3) {
                    System.out.println("3B");
                } else {
                    System.out.println(B + "B" + S + "S");
                }
            }
        }
        System.out.println(a + "번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
        }
        // 컨테인 함수 생성
        public static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num==value) {
            return true;
            }
        }
        return false;
    }
    }
