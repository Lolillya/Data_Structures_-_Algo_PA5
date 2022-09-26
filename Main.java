import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int decValue = 0;
        int targetBase = 0;
        Stack<String> res = new Stack<String>();
        
        while(true)
        {
            while(true){
                System.out.print("Decimal value: ");
                decValue = in.nextInt();
                break;
            }

            if(decValue <= -1)
                break;

            while(true){
                System.out.print("Target base: ");
                targetBase = in.nextInt();

                if(targetBase >= 2 && targetBase <= 16)
                    break;
            }

            if(targetBase >= 2 && targetBase < 16){
                Converstion convert = new Converstion(decValue, targetBase);
                while(convert.getDec() > 0)
                    res.push(String.valueOf(convert.convertTo()));
                System.out.print("The Value of " + decValue + " in base " + targetBase + " is: ");

                while(res.size() > 0){
                    System.out.print(res.peek());
                    res.pop();
                }
                System.out.println();
            }

            else if(targetBase == 16){
                Converstion convert = new Converstion(decValue, targetBase);
                while(convert.getDec() > 0)
                    res.push(convert.hexaDecimalNum());
                System.out.print("The Value of " + decValue + " in base " + targetBase + " is: ");

                while(res.size() > 0){
                    System.out.print(res.peek());
                    res.pop();
                }
                System.out.println();
            }
        }
        System.out.print("thank you for using the program. bye!");
        in.close();
    }
}

class Converstion{
    private int dec;
    private int target;

    public Converstion(int dec, int target) {
        this.dec = dec;
        this.target = target;
    }

    public int getDec() {
        return dec;
    }

    public int convertTo(){
        int rem = this.dec % this.target;
            this.dec /= this.target;
        return rem;
    }

    public String hexaDecimalNum(){
        String res = "";
        int rem = this.dec % this.target;
        res = String.valueOf(rem);
        this.dec /= this.target;

        if(rem == 10)
            res = "A";
        else if(rem == 11)
            res = "B";
        else if(rem == 12)
            res = "C";
        else if(rem == 13)
            res = "D";
        else if(rem == 14)
            res = "E";
        else if(rem == 15)
            res = "F";

        return res;
    }
}