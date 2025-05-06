package com.example.calculator;
import java.util.ArrayList;

/****************************************
 * Calculator
 * 사칙연산 수행 후, 결과값 반환 메서드
 * 연산 결과 저장 컬렉션
 ****************************************/

public class Calculator {
    private ArrayList<Double> arr = new ArrayList<>();


    // 사칙연산 기호 check
    public boolean signCheck(int num2, char str){
        if (str=='+' || str=='-' || str=='*' ) {
            return true;
        }
        else if (str=='/') {
            if (num2 == 0) {
                // 분모 0일 때
                System.out.println("0으로 나눌 수 없습니다.");
                return false;
            } else
                return true;
        }else {
            System.out.println("잘못된 입력입니다.");
            return false;
        }
    }

    // 계산 메서드 구현
    // add(), subtract(), multiply(), divide(), evaluateExpression()
    public double calculate(int num1, int num2, char sign){
        double rslt = switch (sign) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> (double) num1 / num2;
            default -> 0;
        };
        return rslt;
    }

    public ArrayList<Double> getArr(){
        return new ArrayList<>(arr);
    }

    public void setArr(ArrayList<Double> arr){
        this.arr = arr;
    }

    // 결과 삭제 메서드
    public void removeResult(ArrayList<Double> list) {
        if (!list.isEmpty()) {
            list.remove(0);
        } else {
            System.out.println("저장된 데이터가 없습니다.");
        }

    }
}

