class Gradingsystem
{
    public static void main(String[] args)
    {   
        int score = 80;
        int grade= score/10;

        switch (grade) 
        {

         case 10:
         case 9:  
            System.out.println("A");
         break;
         case 8:
            System.out.println("B");
         break;
         case 7:
            System.out.println("C");
        break;
         case 6:
            System.out.println("D");
         break;
         case 5:
            System.out.println("F");
         break;
         default:
           System.out.print("Pathetic");
        }




    }

}