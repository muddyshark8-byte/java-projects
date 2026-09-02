public class Loops
{
    public static void main (String[] args)     //WHILE LOOP
    {
        int i = 1;

        while (i<=4)
        {
            System.out.println("Hi " + i);
            int j = 1;
            while(j<=3){
                System.out.println("Hello");  //NESTED LOOP
             j++;
     
            }
            
             i++;
        }
            System.out.println ("bye " + i);


    }
        

}