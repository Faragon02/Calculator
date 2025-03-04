package calculator;

public class Calculator <T extends Number> {
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

    public double getReuslt (){
      switch (operatorType)
      {
          case '+':
              result = add();
              break;
          case '-':
              result = subtract();
              break;
          case '*':
              result = multiply();
              break;
          case '/':
              result = divide();
              break;
      }
      return  result;
    }
    public  double getInput1(){
        return input1.doubleValue();
    }

    public  double getInput2(){
        return input2.doubleValue();
    }

    public  double getOnlyResult(){
        return result;
    }

    public char getOperatorType(){
        return  operatorType;
    }

    //function
    private  <T extends Number> double add(){
        return input1.doubleValue() + input2.doubleValue();
    }

    private  <T extends Number> double subtract(){
        return input1.doubleValue() - input2.doubleValue();
    }

    private  <T extends Number> double multiply(){
        return input1.doubleValue() * input2.doubleValue();
    }

    private  <T extends Number> double divide() {
        double tempResult = 0.0;
        if (input2.doubleValue() != 0) {

            tempResult = input1.doubleValue() / input2.doubleValue();
        } else {
            tempResult = 0.0;
            throw new ArithmeticException("분모가 영이 될수 없습니다.");
        }
        return tempResult;
    }
}
