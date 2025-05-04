package com.example.calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private ArrayList<T> arr = new ArrayList<>();

    public enum OperatorType {
        ADD('+') {
            @Override
            public <T extends Number> double calculator(T num1, T num2) {
                return num1.doubleValue() + num2.doubleValue();
            }
        },
        SUB('-') {
            @Override
            public <T extends Number> double calculator(T num1, T num2) {
                return num1.doubleValue() - num2.doubleValue();
            }
        },
        MUL('*') {
            @Override
            public <T extends Number> double calculator(T num1, T num2) {
                return num1.doubleValue() * num2.doubleValue();
            }
        },
        DIV('/') {
            @Override
            public <T extends Number> double calculator(T num1, T num2) {
                return num1.doubleValue() / num2.doubleValue();
            }
        };

        private final char oper;

        OperatorType(char oper) {
            this.oper = oper;
        }

        public char getOper() {
            return oper;
        }

        public abstract <T extends Number> double calculator(T num1, T num2);
    }

    // 연산자 체크
    public boolean signCheck(T num2, char ch) {
        for (OperatorType op : OperatorType.values()) {
            if (op.getOper() == ch) {
                if (op == OperatorType.DIV && num2.doubleValue() == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return false;
                }
                return true;
            }
        }
        System.out.println("잘못된 입력입니다.");
        return false;
    }

    // 계산 메서드
    public double calculate(T num1, T num2, char sign) {
        for (OperatorType op : OperatorType.values()) {
            if (op.getOper() == sign) {
                return op.calculator(num1, num2);
            }
        }
        return 0;
    }

    public ArrayList<T> getArr() {
        return new ArrayList<>(arr);
    }

    public void setArr(ArrayList<T> arr) {
        this.arr = arr;
    }

    public void removeResult(ArrayList<T> list) {
        if (!list.isEmpty()) {
            list.remove(0);
        } else {
            System.out.println("저장된 데이터가 없습니다.");
        }
    }

    public List<T> bigg(double k) {
        return arr.stream()
                .filter(x -> x.doubleValue() > k)
                .collect(Collectors.toList());
    }
}
