 class Booleanpractice
  {
    public static void main(String[] args)
    {

      int a= 20;
      int b= 41;

      boolean result = a>b;
      System.out.print (result);
      if (result)
      {
        System.out.print ("CLAUDE IS DA GOAT");
      }
       else
       { 
        System.out.print ("Chatgpt is mid");

       }
         // MOVIE TICKET ELIGIBILITY

         int age =10;
         boolean hasTicket =true;
         boolean withAdult =true;

         boolean canWatch = (age >=13 && hasTicket) || withAdult;

         if (canWatch)
         {
            System.out.print ("You can watch the movie! Have a great time!");

         }
         else 
         {
            System.out.print ("Sorry! Go back to your house");
         }




   }
 }