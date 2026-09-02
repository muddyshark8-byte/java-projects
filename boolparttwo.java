class boolparttwo   // AMUSEMENT PARK ACCESS
{

        public static void main (String [] args)    
        {
           
            int age= 5;
            int height =119;

            boolean Adult = false;
            boolean Child = true;

            boolean canRide= (age >= 8 && height >= 120) || Adult;
            boolean Cannotride = (age >= 8 && (height >= 120)) || Child;
            if (canRide)
            {
                System.out.print ("Have fun and try not to choke!");
            }
             else if (Cannotride)
             {
                System.out.print ("Go to the kiddes section, thank you. If you're lost, find the nearest adult and ask for assistance");
             }
              
            

            // LOGIN CHECK

            boolean correctUsername= true;
            boolean correctpassword= false;
            boolean hasToken= false;
            
            
            boolean canlogin= (correctUsername && correctpassword) || hasToken;
            if (canlogin)
            {
                System.out.print ("Welcome back user!");
            }
            else
            {
                System.out.print ("Hmm... You sure its you bro?");
        }   }
}       