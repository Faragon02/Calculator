package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int add(int input1, int input2){
        int result = 0;
        return  result = input1 + input2;
    }

    static int subtract(int input1, int input2){
        int result = 0;
        return  result = input1 - input2;
    }

    static int multiply(int input1, int input2){
        int result = 0;
        return  result = input1*input2;
    }

    static int divide(int input1, int input2){
        int result = 0;
        try
        {
            result =input1 / input2;
        }
        catch (ArithmeticException e) {

            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다 ");
            result =0;
        }
        finally {
            return result = 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = 0;
        int input2 = 0;
        int result = 0;

        char operatorType;
        char[] operatorTypes = {'+','-','*','/'};

        boolean start =  true;
        boolean calculateStatue = false;

        while (start)
        {
            System.out.println("=================================================");
            System.out.println("연산기호 입력: + (덧셈), - (뺄셈), * (곱셈), / (나누기)");
            operatorType = scanner.next().charAt(0);
            for(char oper : operatorTypes)
            {
                if(operatorType == oper)
                {
                    calculateStatue = true;
                    break;
                }
            }
            if(calculateStatue)
            {
                try
                {
                    System.out.println("첫번째 정수를 입렵하세요.");
                    input1 = scanner.nextInt();

                }
                catch (InputMismatchException ex)
                {
                    System.out.println("다시 첫번째 정수를 입렵하세요.");
                    scanner.nextLine();
                    input1 = scanner.nextInt();
                }

                try
                {
                    System.out.println("두번째 정수를 입렵하세요.");
                    input2 = scanner.nextInt();

                }
                catch (InputMismatchException ex)
                {
                    System.out.println("다시 두번째 정수를 입렵하세요.");
                    scanner.nextLine();
                    input2 = scanner.nextInt();

                }

                switch (operatorType)
                {
                    case '+':
                        result = add(input1, input2);
                        break;
                    case '-':
                        result = subtract(input1, input2);
                        break;
                    case '*':
                        result = multiply(input1, input2);
                        break;
                    case '/':
                        result = divide(input1, input2);
                        break;
                    default:
                        break;
                }

                System.out.println("결과 :  " + result);
            }
            else
            {
                System.out.println("존재하지 않는 기능입니다.");
            }
            System.out.println("종료 할까요? 'exit' / 계속(p)");
            String exit =scanner.next();
            if (exit.equals("exit")) {
                System.out.println("프로그램 정상 종료");
                start = false;
                scanner.close();
                break;
            }

        }
    }
}
