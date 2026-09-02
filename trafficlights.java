class trafficlights
{
    public static void main (String[] args)
    {

        String colour= "yellow";

        switch (colour) 
        {

            case "red":
            System.out.println("Stop");
            break;

            case "yellow":
            System.out.println("slow down");
            break;

            case "green":
            System.out.println("Go");
            break;

            default:
            System.out.println("Error. invalid colour");
            break;
        }

    }


}