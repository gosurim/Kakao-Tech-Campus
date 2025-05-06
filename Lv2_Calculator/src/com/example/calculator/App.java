package com.example.calculator;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        ArrayList<Double> tempArr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        char sign;
        String flag;


        boolean flag2 = true;
        while (flag2) {
            tempArr=cal.getArr();
            System.out.print("첫 번째 숫자(양의 정수): ");
            num1 = sc.nextInt();
            System.out.print("두 번째 숫자(양의 정수): ");
            num2 = sc.nextInt();


            // 사칙연산 선택
            // 계산 기능
            do{
                while(true){
                    System.out.print("사칙연산 선택(+, -, *, /): ");
                    sign = sc.next().charAt(0);
                    if (cal.signCheck(num2, sign)){
                        break;
                    }else {
                        System.out.println("다시 입력해주십시오.");
                    }
                }
                double rslt=cal.calculate(num1, num2, sign);
                tempArr.add(rslt);
                if (sign!='/'){
                    System.out.printf("%d %c %d = %.0f\n", num1, sign, num2, rslt);
                }
                else System.out.println(num1 + " " + sign + " " + num2 + " = " + rslt);

                System.out.print("다시 계산하시겠습니까? (종료: exit 입력) ");
                flag = sc.next();
            }while(!flag.equals("exit"));


            // 결과 조회(getter), 삭제(remove메서드), 저장(setter)
            while(true){
                System.out.println("\n[menu]\n(1) 현재 결과 조회\n(2) 가장 먼저 계산된 데이터 삭제\n(3) 결과 저장\n(4) 저장된 결과 조회\n(5) 다음");
                int temp=sc.nextInt();
                if (temp==1) System.out.println(tempArr);
                else if (temp==2) cal.removeResult(tempArr);
                else if (temp==3) cal.setArr(tempArr);
                else if (temp==4) System.out.println(cal.getArr());
                else if (temp==5) break;
            }

            // 숫자 입력 반복 여부
            System.out.println("숫자를 다시 입력 하시겠습니까? (종료: N, 아무 문자-다시 입력)");
            String str = sc.next();
            if (str.equals("N")) {
                System.out.println("계산기 종료");
                flag2 = false;
            }
        }
    }
}
