class fizzbuzz
{
    public static void main (String[] args)
    {
        int fizzcount=0;
        int  buzzcount = 0;
        int fizzbuzzcount=0;
        int numbercount=0;
       for (int i= 1; i<=50; i++)
       {
            if (i % 5==0 && i % 3==0)
            {
              System.out.println("FizzBuzz");
              fizzbuzzcount++;
            }
           else if ( i % 5==0)
             
            {
                System.out.println("Buzz");
                buzzcount++;
            }
          else if (i % 3 ==0)
              
            {
                System.out.println("Fizz");
                fizzcount++;
            }
            else
            {
                System.out.println(i);
                numbercount++;
            }
       }   
          System.out.println("Fizz count: " + fizzcount);
          System.out.println("FizzBuzz count: " + fizzbuzzcount);
          System.out.println("Buzz count: " + buzzcount);
          System.out.println("Plain number count: " + numbercount);
    }
}