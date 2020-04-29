import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<String> meat_list = Arrays.asList("chicken", "steak", "carnidas", "chorizo", "sofritas", "veggie meat", "none", "all");
        meat.addAll(meat_list);
        // beans arraylist
        List<String> beans_list = Arrays.asList("pinto", "black", "none", "all");
        beans.addAll(beans_list);

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


        for (int num_burrido = 0; num_burrido < 25; num_burrido++) {

            // integer variable to store quntity & price of burrido

            int qty_for_rate = 0;
            double burrito_price;

            // arraylist to store selected ingredients
            ArrayList<Integer> index_ingredients = new ArrayList<>();

            // arraylist of index of each specific component among the ingredients
            ArrayList<Integer> burrito_component = new ArrayList<>();
            // arraylist of index of each component for cashier
            ArrayList<String> burrito_for_cashier = new ArrayList<>();

            // generate a random number to decide how many ingredients
            // between 5 to (9+1) ... rnd_high = 10 and rnd_low = 5;
            int how_many_ingredients = generate_random(10, 5);

            // equal to how many ingredients generated above
            // generate index to randomly select ingredints among the nine
            int index_of_which_ingredient;

            // the generated numbers from 0 to 8 no duplicate
            for (int i = 0; i < how_many_ingredients; i++) {

                // rnd_high = (8 + 1) and rnd_low = 0
                index_of_which_ingredient = generate_random(9, 0);

                if (i > 0) {

                    if (index_ingredients.contains(index_of_which_ingredient)) {
                        i--;
                    } else {
                        index_ingredients.add(index_of_which_ingredient);
                    }
                } else {
                    index_ingredients.add(index_of_which_ingredient);
                }   // end if loop
            }   // end for loop
            bubblesort(index_ingredients);

            for (int i = 0; i < how_many_ingredients; i++) {

                int rnd_high = all_ingredients.get(index_ingredients.get(i)).size();

                if (rnd_high == 0) {
                    rnd_high++;
                }
                int rnd_low = 0;
                int temp = generate_random(rnd_high, rnd_low);
                burrito_component.add(temp);
            }   // end for loop


            for (int i = 0; i < how_many_ingredients; i++) {

                String temp = all_ingredients.get(index_ingredients.get(i)).get(burrito_component.get(i));
                // list of components selected in a burrito for cashier
                burrito_for_cashier.add(temp);
            }   // end for loop

            //calculate rate of each ingredient
            for (int i = 0; i < burrito_for_cashier.size(); i++) {
                boolean temp_no = false;
                boolean temp_none = false;
                temp_no = burrito_for_cashier.get(i).equalsIgnoreCase("no");
                temp_none = burrito_for_cashier.get(i).equalsIgnoreCase("none");

                if (temp_no || temp_none) {

                } else {
                    qty_for_rate++;
                }   // end if loop
            }   // end of for loop
            burrito_price = 3 + (qty_for_rate * 0.5);
            System.out.printf("\nBurrito %d: ", (num_burrido + 1));

            // replace strings like "no", "none", "all", "yes"
            //for rice
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 0 && burrito_component.get(k) == 2){
                    burrito_for_cashier.set(2, "no rice");
                }
                else if(index_ingredients.get(k) == 0 && burrito_component.get(k) == 3){
                    burrito_for_cashier.set(3, "all rice");
                }
            }
            // for meat
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 1 && burrito_component.get(k) == 6){
//                    burrito_for_cashier.set(6, "no meat");
                }
                else if(index_ingredients.get(k) == 1 && burrito_component.get(k) == 7){
//                    System.out.println();
//                    burrito_for_cashier.set(7, "all meat");
                }
            }
            // for beans
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 2 && burrito_component.get(k) == 2){
                    burrito_for_cashier.set(2, "no beans");
                }
                else if(index_ingredients.get(k) == 2 && burrito_component.get(k) == 3){
                    burrito_for_cashier.set(3, "all beans");
                }
            }
            // for salsa
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 3 && burrito_component.get(k) == 3){
                    burrito_for_cashier.set(3, "no salsa");
                }
                else if(index_ingredients.get(k) == 3 && burrito_component.get(k) == 4){
                    burrito_for_cashier.set(4, "all salsa");
                }
            }
            // for veggies
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 4 && burrito_component.get(k) == 2){
                    burrito_for_cashier.set(2, "no salsa");
                }
                else if(index_ingredients.get(k) == 4 && burrito_component.get(k) == 3){
                    burrito_for_cashier.set(3, "all salsa");
                }
            }
            // for chese
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 5 && burrito_component.get(k) == 0){
                    burrito_for_cashier.set(0, "cheese");
                }
                else if(index_ingredients.get(k) == 5 && burrito_component.get(k) == 1){
                    burrito_for_cashier.set(1, "no cheese");
                }
            }
            // for guac
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 6 && burrito_component.get(k) == 0){
                    burrito_for_cashier.set(0, "guac");
                }
                else if(index_ingredients.get(k) == 6 && burrito_component.get(k) == 1){
                    burrito_for_cashier.set(1, "no guac");
                }
            }
            // for queso
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 7 && burrito_component.get(k) == 0){
                    burrito_for_cashier.set(0, "queso");
                }
                else if(index_ingredients.get(k) == 7 && burrito_component.get(k) == 1){
                    burrito_for_cashier.set(1, "no queso");
                }
            }
            // for sourcream
            for(int k = 0 ; k < how_many_ingredients; k++){
                if(index_ingredients.get(k) == 7 && burrito_component.get(k) == 0){
                    burrito_for_cashier.set(0, "sour cream");
                }
                else if(index_ingredients.get(k) == 7 && burrito_component.get(k) == 1){
                    burrito_for_cashier.set(1, "no sourcream");
                }
            }

            for (int i = 0; i < burrito_for_cashier.size(); i++) {

                if (i > 0) {
                    System.out.print(", ");
                }


                System.out.printf("%s ", burrito_for_cashier.get(i));
            }

            System.out.printf("\t\t$%.2f", burrito_price);
            System.out.print("\n-------------------------------------------------------------------------");

        }   // end of for loop

    }   // end of main()

    // a method to generate random number
    public static int generate_random(int max, int min){
        // initialize Random class
        Random rnd = new Random();

        if(max == 0){
            max++;
        }
        int result = min + rnd.nextInt(max - min);
        return result;
    }
    // method to sort results
    public static void bubblesort(ArrayList <Integer> sorted_alist){
        int n1 = sorted_alist.size();
        for(int i = 0; i < n1-1; i++){
            for(int j = 0; j < n1-i-1; j++){
                int a = sorted_alist.get(j+1);
                int b = sorted_alist.get(j);
                if (a < b) {
                    int temp = a;
                    sorted_alist.set(j+1, b);
                    sorted_alist.set(j, temp);
                }
            }
        }
    }   // end of bubblesort() class
}   // end of class