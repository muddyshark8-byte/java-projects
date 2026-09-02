class Calculator
{
   int a;
   
   public int add(int n1, int n2)
   {
     int r= n1 + n2;
  return r;
   }
}






public class Calculatorpractice 

{
        public static void main(String[] args) 
        {
         int num1=50;
         int num2=90;
         Calculator calc = new Calculator();

         int result= calc.add(50, 90);

         System.out.print("The sum of " + num1 + " and " + num2 + " is: " + result);
            
        }   
}
