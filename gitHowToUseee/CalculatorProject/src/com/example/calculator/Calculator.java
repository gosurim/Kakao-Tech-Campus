package com.example.calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        String flag;
        char sign;

        boolean flag2=true;
        while(flag2) {
            System.out.print("첫 번째 숫자(양의 정수): ");
            num1 = sc.nextInt();
            System.out.print("두 번째 숫자(양의 정수): ");
            num2 = sc.nextInt();

            while (true) {
                System.out.print("사칙연산 선택(+, -, *, /): ");
                sign = sc.next().charAt(0);

                switch (sign) {
                    case '+':
                        System.out.println(num1 + num2);
                        break;
                    case '-':
                        System.out.println(num1 - num2);
                        break;
                    case '*':
                        System.out.println(num1 * num2);
                        break;
                    case '/':
                        if (num2>0)  System.out.println(num1 / num2);
                        // 0입력 예외처리
                        else System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    default:
                        System.out.println("잘못 입력 되었습니다.");
                }
                // 사칙연산 입력 반복 여부 확인
                System.out.println("다시 계산하시겠습니까? (exit 입력 시 종료)");
                flag = sc.next();
                if (flag.equals("exit")) {
                    break;
                }
            }
            // 숫자 입력 반복 여부
            System.out.println("숫자를 다시 입력 하시겠습니까?(N 입력 시 종료)");
            String str= sc.next();
            if (str.equals("N")) {
                flag2=false;
            }
        }
    }
}
