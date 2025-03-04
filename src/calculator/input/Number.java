package calculator.input;

public class Number <T>{
    public  T value;

    Number(T value){
        this.value = value;
    }

    public  T getValue(){
        return  this.value;
    }

}
