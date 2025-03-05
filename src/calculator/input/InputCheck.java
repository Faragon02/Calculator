package calculator.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCheck {
   public InputCheck(){}
   public double checkDouble(String command, Scanner scanner)
    {
        double tempInput;
        while (true)
        {
            try
            {
                System.out.println(command);
                tempInput = scanner.nextDouble();
                return  tempInput;
            }
            catch (InputMismatchException ex){
                System.out.println("[Exception] 숫자를 입력하세요");
                scanner.nextLine();
            }
        }

    }
    public int checkInt(String command, Scanner scanner)
    {
        int tempInput;
        while (true)
        {
            try
            {
                System.out.println(command);
                tempInput = scanner.nextInt();
                return  tempInput;
            }
            catch (InputMismatchException ex){
                System.out.println("[Exception] 숫자를 입력하세요");
                scanner.nextLine();
            }
        }

    }
}
