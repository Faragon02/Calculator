package calculator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private int input1;
    private int input2;
    private int result;
    char operatorType;

    //previewDatacheck
    Map<Integer,String> previous ;
    private int countObj;
    private int maxCount = 2;
    Calculator(){
        input1 = 0;
        input2 = 0;
        result = 0;
        countObj = 0;
        previous =new HashMap<>();
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

        updatePreviewData(); // this next when After Calc
    }


    //previousDataCallFunction
    void updatePreviewData()
    {
        String oldData = previous.get(0);
        if(maxCount < previous.size())
        {

            previous.remove(oldData);
            for(int i =0 ; i < maxCount; i++)
            {
                previous.put(i , previous.remove(i));
            }
            countObj = previous.size();
        }
        String tempNow = String.format("%d %c %d = %d", input1,operatorType, input2, result);
        previous.put(countObj++, tempNow);
    }

    int previousMaxCount() {
        return  maxCount;
    }
    int countPreviewData()
    {
        int count = previous.size();
        return count;
    }
    String callpreviousData(int num)
    {
        if(num > previous.size())
        {
            num = previous.size() -1;
        }
        return previous.get(num);
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
