package calculator;

import calculator.input.InputCheck;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator<Double> calculator = new Calculator<>();
        Previous previous = new Previous(5);
        InputCheck check = new InputCheck();

        int selectInput;
        String command;

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
                    calculator.setOperatorType(operatorType);
                    break;
                }
            }
            command = "첫번째 수를 입력하세요";
            calculator.setInput1( check.checkDouble(command, scanner));

            command = "두번째 수를 입력하세요";
            calculator.setInput2(check.checkDouble(command, scanner));
            if(calculateStatue)
            {
                System.out.println("결과 :  " + calculator.getReuslt());

                previous.setUpdatePreviewData(calculator.getInput1(), calculator.getOperatorType(),
                        calculator.getInput2(), calculator.getReuslt());

                int countPrevious= previous.countPreviewData();
                System.out.println("이전 데이터를 보겠습니까? y/n (Yes/N0)");
                char tempPreviousCmd1= scanner.next().charAt(0);
                if(tempPreviousCmd1 == 'y' |tempPreviousCmd1 =='Y')
                {
                    System.out.println( String.format("총 개수는 %d개 이상이되면 오래된 것부터 자동 삭제합니다.", previous.previousMaxCount()));
                    System.out.println("총 개수 : " + previous.countPreviewData() + "\n\n");

                    for(int i = 0; i< countPrevious; i++){
                        System.out.println( i + " 번째: " + previous.callpreviousData(i));
                    }
                    command = "삭제할 데이터 선택: 정수 숫자 / 없으면 -1";
                    selectInput = check.checkInt(command, scanner);

                    command = "수를 입력하세요 / 없으면 -1";
                    selectInput = check.checkInt(command, scanner);

                    if( selectInput >=0)
                    {
                        System.out.println(previous.removeData(selectInput));

                        countPrevious= previous.countPreviewData();
                        System.out.println("현재 상태" +  countPrevious);
                        if(countPrevious >0)
                        {
                            for(int i = 0; i< countPrevious; i++){
                                System.out.println( i + " 번째: " + previous.callpreviousData(i));
                            }
                        }
                    }

                }
               // System.out.println(calculator.removeData(selectInput) );
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
