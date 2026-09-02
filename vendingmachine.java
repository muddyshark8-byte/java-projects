class vendingmachine
{
    public static void main (String [] args)
    {
        char Selection= 'A';

        switch (Selection)
       {
            case 'A':
            System.out.println("Here are your fragrant chips");
            break;

            case 'B':
            System.out.println("A fizzy soda for a hot day");
            break;

            case 'C':
            System.out.println("Have some candy. There is a little kid in all of us");
            break;

            case 'D':
            System.out.println("Water slams everyday of the week");
            break;

            default:
            System.out.println("Sorry! We do not have that right now!");
            break;
        }

    }


}