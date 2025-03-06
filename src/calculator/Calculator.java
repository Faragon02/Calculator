package calculator;

public class Calculator <T extends Number> {
    //number check!
    private T input1;
    private T input2;
    private double result;
    private char operatorType;

    Calculator(){

        result = 0;
    }
    //set
    public void setInput1(T input1){
        this.input1 =input1;
    }
    public  void setInput2(T input2){
        this.input2 = input2;
    }

    public  void setOperatorType(char operatorType)
    {
        this.operatorType = operatorType;
    }

    public void getCalc(){
      switch (operatorType)
      {
          case '+':
              result = add(input1, input2) ;
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
      }
        System.out.println("결과 :  " + result);
    }
    public  String getSaveCalc(){
      return  String.format("%.3f %c %.3f = %.3f", input1, operatorType, input2 , result);
    }
    public void getOutput(){
        System.out.println("입력1   : " + input1);
        System.out.println("연산기호 : " + operatorType);
        System.out.println("입력2   : " + input2);
        System.out.println("결과    : " + result);
    }

    //function
    private <T extends Number> double add(T input1, T input2){
        return input1.doubleValue() + input2.doubleValue();
    }

    private <T extends Number> double subtract(T input1, T input2){
        return input1.doubleValue() - input2.doubleValue();
    }

    private <T extends Number> double multiply(T input1, T input2){
        return input1.doubleValue() * input2.doubleValue();
    }

    private <T extends Number> double divide(T input1, T input2) {
        double tempResult = 0.0;
        if (input2.doubleValue() != 0) {

            tempResult = input1.doubleValue() / input2.doubleValue();
        } else {
            tempResult = 0.0;
            System.out.println("0으로 나눌수 없습니다.");
        }
        return tempResult;
    }
}
