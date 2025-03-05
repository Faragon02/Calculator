package calculator;

import java.util.ArrayList;
import java.util.List;

public class Previous{

    //previewDataCheck
    private final List<String> previous;
    private int maxCount;
    private int previousCount;

    Previous(int maxCount){
        this.maxCount = maxCount;
        previousCount = 0;
        previous = new ArrayList<>();
    }
    //previousDataCallFunction
    public void setUpdatePreviewData(String result)
    {
        previous.add(result);
    }
    public void getReadData(char command) {
        if (command == 'Y' || command == 'y') {
            if(previous.size() > maxCount)
            {
                previous.remove(0);
            }
            System.out.println("총 개수는 "+ maxCount +"개 이상이되면 오래된 것부터 자동 삭제합니다.");
            System.out.println("총 개수 :" +previousCount + "\n\n");
            refreshPreviousData();
        }
    }
    public void removeData(int inputNum)
    {
        if(inputNum  < 0){
            return;
        }
        int size =previous.size();
        if( size == 0){
            return;
        }
        String complite;
        if(inputNum < maxCount)
        {
            previous.remove(inputNum);
            complite=  "삭제 :" + inputNum + " 번째 삭제 성공\n\n";
        }
        else
        {
            complite ="삭제 :" +  inputNum + " 번째 삭제 실패\n "
                    + maxCount + " 보다 크기 입력했습니다.\n\n";
        }
        System.out.println(complite);
        refreshPreviousData();
    }

    private void refreshPreviousData(){
        int i =0;
        for(String s : previous)
        {
            System.out.println(i +" 번째 :"+ s);
            i++;
        }
    }
}
