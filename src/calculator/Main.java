package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int input1 = 0;
        int input2 = 0;

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
                calculator.setDataInput(input1, operatorType, input2);
                System.out.println("결과 :  " +calculator.getResult());

                System.out.println("입력한 데이터를 보겠습니까? y/n (Yes/N0)");
                char tempCmd= scanner.next().charAt(0);
                if(tempCmd == 'y' ||tempCmd =='Y')
                {
                    System.out.println("입력1 : " + calculator.getinput1());
                    System.out.println("입력2 : " + calculator.getinput2());
                    System.out.println("결과 :  " +calculator.getResult());
                }
                System.out.println("입전 데이터를 보겠습니까? y/n (Yes/N0)");
                char tempPreviousCmd1= scanner.next().charAt(0);
                if(tempPreviousCmd1 == 'y' |tempPreviousCmd1 =='Y')
                {
                    System.out.println( String.format("총 개수는 %d개 이상이되면 오래된 것부터 삭제합니다.", calculator.previousMaxCount()));
                    System.out.println("총 개수 : " + calculator.countPreviewData() + "\n\n");
                    int countPrevious= calculator.countPreviewData();
                    for(int i = 0; i< countPrevious; i++){
                        System.out.println(calculator.callpreviousData(i));

                    }
                }
            }
            else
            {
                System.out.println("존재하지 않는 기능입니다.");
            }
            System.out.println("종료 할까요? 종료(q,Q) / 계속(p,P)");
            char exit =scanner.next().charAt(0);
            if (exit == 'q' ||exit == 'Q') {
                System.out.println("프로그램 정상 종료");
                start = false;
                scanner.close();
                break;
            }

        }
    }
}
