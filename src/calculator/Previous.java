package calculator;

import java.util.ArrayList;
import java.util.List;

public class Previous {

    //previewDatacheck
    private List<String> previous;
    private int maxCount;
    private int previousCount;

    Previous(int maxCount){
        this.maxCount = maxCount;
        previousCount = 0;
        previous = new ArrayList<String>();
    }
    //previousDataCallFunction
    public void setUpdatePreviewData(double input1, char oper , double input2, double result)
    {
        if(previous.size() > maxCount)
        {
            previous.remove(0);
        }
        String tempNow = String.format("%.3f %c %.3f = %.3f", input1, oper, input2 , result);
        previous.add(tempNow);
        countPreviewData();
    }

    int previousMaxCount() {
        return  maxCount;
    }
    int countPreviewData()
    {
        previousCount = previous.size();

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
        if(inputNum < maxCount)
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
}
