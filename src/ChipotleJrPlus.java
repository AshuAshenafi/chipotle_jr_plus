import java.util.ArrayList;
import java.util.Random;

public class ChipotleJrPlus {
    public static void main(String[] args) {

        // initialize Random class
        Random rnd = new Random();

        // declare arraylists
        ArrayList<String> rice = new ArrayList<>();
        ArrayList<String> meat = new ArrayList<>();
        ArrayList<String> beans = new ArrayList<>();
        ArrayList<String> salsa = new ArrayList<>();
        ArrayList<String> veggies = new ArrayList<>();
        ArrayList<String> cheese = new ArrayList<>();
        ArrayList<String> guac = new ArrayList<>();
        ArrayList<String> queso = new ArrayList<>();
        ArrayList<String> sourcream = new ArrayList<>();
        // array of all available ingredients
        ArrayList<ArrayList<String>> all_ingredients = new ArrayList<ArrayList<String>>();
        all_ingredients.add(rice);
        all_ingredients.add(meat);
        all_ingredients.add(beans);
        all_ingredients.add(salsa);
        all_ingredients.add(veggies);
        all_ingredients.add(cheese);
        all_ingredients.add(guac);
        all_ingredients.add(queso);
        all_ingredients.add(sourcream);

        // populate the arraylists
        // rice arraylist
        rice.add("white");
        rice.add("brown");
        rice.add("none");
        rice.add("all");
        // meat arraylist
        meat.add("chicken");
        meat.add("steak");
        meat.add("carnidas");
        meat.add("chorizo");
        meat.add("sofritas");
        meat.add("veggie meat");
        meat.add("none");
        meat.add("all");
        // beans arraylist
        beans.add("pinto");
        beans.add("black");
        beans.add("none");
        beans.add("all");
        // salsa arraylist
        salsa.add("mild");
        salsa.add("medium");
        salsa.add("hot");
        salsa.add("none");
        salsa.add("all");
        // veggies arraylist
        veggies.add("lettuce");
        veggies.add("fajita veggies");
        veggies.add("none");
        veggies.add("all");
        // cheese arraylist
        cheese.add("yes");
        cheese.add("no");
        // guac arraylist
        guac.add("yes");
        guac.add("no");
        // queso arraylist
        queso.add("yes");
        queso.add("no");
        // sour cream arraylist
        sourcream.add("yes");
        sourcream.add("no");


        for(int num_burrido = 0; num_burrido < 25; num_burrido++){            // send this sentence at the first line of main mtehod ????

        // integer variable to store quntity & price of burrido, plus
        // minimum and maximum range for random numbers
        int rnd_high;
        int rnd_low;
        int qty_for_rate = 0;
        double burrito_price;

        // arraylist to store selected ingredients
        ArrayList<Integer> index_ingredients = new ArrayList<>();

        // arraylist of index of each specific component among the ingredients
        ArrayList<Integer> burrito_component = new ArrayList<>();
        // arraylist of index of each component for cashier
        ArrayList<String> burrito_for_cashier = new ArrayList<>();

        // generate a random number to decide how many ingredients between 5 to (9+1)
        rnd_high = 10;
        rnd_low = 5;

        int how_many_ingredients = rnd_low + rnd.nextInt(rnd_high - rnd_low);

        // equal to how many ingredients generated above
        // generate index to randomly select ingredints among the nine
        int index_of_which_ingredient;

        // the generated numbers from 0 to 8 no duplicate
        for(int i = 0; i < how_many_ingredients; i++){

            rnd_high = (8+1);
            rnd_low = 0;
            index_of_which_ingredient = rnd_low + rnd.nextInt(rnd_high - rnd_low);

            if(i > 0){

                if(index_ingredients.contains(index_of_which_ingredient)){
                    i--;
                }
                else{
                    index_ingredients.add(index_of_which_ingredient);
                }
            }
            else{
                index_ingredients.add(index_of_which_ingredient);

            }

        }

        for(int i = 0; i < how_many_ingredients; i++){


                rnd_high = all_ingredients.get(index_ingredients.get(i)).size();

                if(rnd_high == 0) {
                    rnd_high++;
                }
                rnd_low = 0;
                int temp = rnd_low + rnd.nextInt(rnd_high - rnd_low);
                burrito_component.add(temp);
        }

        for(int i = 0; i < how_many_ingredients; i++){

            String temp = all_ingredients.get(index_ingredients.get(i)).get(burrito_component.get(i));
            // list of components selected in a burrito for cashier
            burrito_for_cashier.add(temp);
        }

        //calculate rate of each ingredient
        for(int i = 0; i < burrito_for_cashier.size(); i++){
            boolean temp_no = false;
            boolean temp_none = false;
            temp_no = burrito_for_cashier.get(i).equalsIgnoreCase("no");
            temp_none = burrito_for_cashier.get(i).equalsIgnoreCase("none");

            if(temp_no || temp_none){

            }
            else{
                qty_for_rate++;
            }
        }

        burrito_price = 3 + (qty_for_rate * 0.5);
            System.out.printf("\nBurrito %d: ", (num_burrido+1));
            for(int i = 0; i < burrito_for_cashier.size(); i++){

                if(i > 0){
                    System.out.print(", ");
                }

                System.out.printf("%s ", burrito_for_cashier.get(i));
            }

            System.out.printf("\t\t$%.2f", burrito_price);
            System.out.print("\n-------------------------------------------------------------------------");

        }   // end of for loop

    }   // end of main()
}   // end of class
