package calculator;

import java.util.*;

public class Calculator {

    private int input1;
    private int input2;
    private int result;
    char operatorType;

    //previewDatacheck
    private  List<String> previous ;
    private int maxCount;
    private int previousCount;


    Calculator(){
        input1 = 0;
        input2 = 0;
        result = 0;
        this.maxCount = 2;
        previousCount = 0;
        previous = new ArrayList<String>();
    }

    //setter & Calc!
    void setDataInput(int input1, char operatorType, int input2)
    {
        this.input1 = input1;
        this.input2 = input2;
        this.operatorType = operatorType;

        switch (this.operatorType)
        {
            case '+':
                add();
                break;
            case '-':
               subtract();
                break;
            case '*':
                multiply();
                break;
            case '/':
                divide();
                break;
            default:
                break;
        }

         // this next when After Calc
    }


    //previousDataCallFunction
    void updatePreviewData()
    {
        if(previous.size() > maxCount)
        {
            previous.remove(0);
        }
        String tempNow = String.format("%d %c %d = %d", input1,operatorType, input2, result);
        previous.add(tempNow);
        previousCount = previous.size();
    }

    int previousMaxCount() {
        return  maxCount;
    }
    int countPreviewData()
    {
       return previousCount;
    }
    String callpreviousData(int num)
    {
        if(num >= previous.size())
        {
            num = previousCount;
        }
        else if(num < 0)
        {
            num = 0;
        }
        return previous.get(num);
    }
    String removeData(int inputNum)
    {
        String complte;
        if(inputNum>= 0 && inputNum < maxCount)
        {
            previous.remove(inputNum);
            complte =  "삭제 :" + inputNum + " 번째 삭제 성공\n\n";
        }
        else
        {
            complte ="삭제 :" +  inputNum + " 번째 삭제 실패\n "
                    + maxCount + " 보다 크기 입력했습니다.\n\n";
        }
        return complte;
    }
    //getter
    int getinput1()
    {
        return  input1;
    }
    int getinput2(){
        return input2;
    }
    int getResult(){
        return result;
    }

    //function
    private void add(){
        result = input1 + input2;
    }

    private void subtract(){
        result = input1 - input2;
    }

    private void multiply(){
        result = input1 * input2;
    }

    private void divide(){
        try
        {
            result =input1 / input2;
        }
        catch (ArithmeticException e) {

            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다 ");
            result =0;
        }
    }
}
