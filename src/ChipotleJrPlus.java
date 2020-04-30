import com.sun.istack.internal.NotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public class ChipotleJrPlus {

    public static DecimalFormat df2 = new DecimalFormat("#.##");

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

        // replace strings like "no", "none", "all", "yes"
        rice.set(0, "white rice");
        rice.set(1, "brown rice");
        rice.set(2, "no rice");
        rice.set(3, "all rice");

        meat.set(6, "no meat");
        meat.set(7, "all meat");

        beans.set(0, "pinto beans");
        beans.set(1, "black beans");
        beans.set(2, "no beans");
        beans.set(3, "all beans");

        salsa.set(0, "mild salsa");
        salsa.set(1, "medium salsa");
        salsa.set(2, "hot salsa");
        salsa.set(3, "no salsa");
        salsa.set(4, "all salsa");

        veggies.set(2, "no veggies");
        veggies.set(3, "all veggies");

        cheese.set(0, "cheese");
        cheese.set(1, "no cheese");

        guac.set(0, "guac");
        guac.set(1, "no guac");

        queso.set(0, "queso");
        queso.set(1, "no queso");

        sourcream.set(0, "sour cream");
        sourcream.set(1, "no sour cream");

        // declare arraylists for summary count purpose
        int[][] all_count = {{0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        double all_price = 0;

        ArrayList<String> burrito_for_summary = new ArrayList<>();

// ******************************************** FOR LOOP for 25 Burritos ********************************************

        for (int num_burrido = 0; num_burrido < 25; num_burrido++) {
            // arraylist of index of each component for cashier
            ArrayList<String> burrito_for_cashier = new ArrayList<>();

            // integer variable to store quntity & price of burrido

            int qty_for_rate = 0;
            double burrito_price;

            // arraylist to store selected ingredients
            ArrayList<Integer> index_ingredients = new ArrayList<>();

            // arraylist of index of each specific component among the ingredients
            ArrayList<Integer> burrito_component = new ArrayList<>();

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

                temp_no = burrito_for_cashier.get(i).contains("no");
                temp_none = burrito_for_cashier.get(i).contains("none");

                if (temp_no || temp_none) {

                } else {
                    qty_for_rate++;
                }   // end if loop
            }   // end of for loop


// *************************************  OUTPUT FOR ONE BURRITO ************************************************

            String one_burrito ="";

            burrito_price = 3 + (qty_for_rate * 0.5);           // price for one burrito

            one_burrito += "\nBurrito : " + (num_burrido + 1);

            // format the output for one burrito ... ummm smelling!!!!!!!!  already
            for (int i = 0; i < burrito_for_cashier.size(); i++) {

                if (i > 0) {
                    // print comma after the first item good formating
                    one_burrito += ", ";
                }

                one_burrito += " " + burrito_for_cashier.get(i);
            }
            all_price += burrito_price;

            System.out.println(format("%-130s %2s %7s", one_burrito, "|", format("$%(,.2f", burrito_price)));

            print_dashes('-', 140);

            // copy the arraylist into another arraylist to calculate the 25 total burritos.
            burrito_for_summary.addAll(burrito_for_cashier);

        }   // end of for loop for 25 Burritos

        String print_summary = "";
        int count = 0;

        for (int k = 0; k < burrito_for_summary.size(); k++) {

            for (int i = 0; i < all_ingredients.size(); i++) {
                for (int j = 0; j < all_ingredients.get(i).size(); j++) {

                    boolean temp1 = burrito_for_summary.get(k).equals(all_ingredients.get(i).get(j));
                    boolean temp2 = !(burrito_for_summary.get(k).contains("no"));       // this represents both "no" and "none"
                    if (temp1 && temp2) {
                        all_count[i][j] = (all_count[i][j] + 1);
                    }
                }
            }
        }

// OUTPUT OUTPUT **************** SUMMARY SENTENCE **************** OUTPUT OUTPUT!

        print_summary += "\nThis order has ";
        for (int i = 0; i < all_count.length; i++) {
            for (int j = 0; (all_count[i] != null && j < all_count[i].length); j++) {

                if (all_count[i][j] > 0) {
                    if (count > 0) {
                        print_summary += ", ";
                    }

                    print_summary += (all_count[i][j] + " " + all_ingredients.get(i).get(j));
                    count++;
                }
            }
        }

        print_summary += ", and the sum is $" + format("%.2f", all_price) + ".";


        // print max of 50 chars per line without truncating a word
        noword_truncate(print_summary);

    }   // end of main()

    // a method to generate random number
    public static int generate_random(int max, int min) {
        // initialize Random class
        Random rnd = new Random();

        if (max == 0) {
            max++;
        }
        int result = min + rnd.nextInt(max - min);
        return result;
    }

    // method to sort results
    public static void bubblesort(ArrayList<Integer> sorted_alist) {
        int n1 = sorted_alist.size();
        for (int i = 0; i < n1 - 1; i++) {
            for (int j = 0; j < n1 - i - 1; j++) {
                int a = sorted_alist.get(j + 1);
                int b = sorted_alist.get(j);
                if (a < b) {
                    int temp = a;
                    sorted_alist.set(j + 1, b);
                    sorted_alist.set(j, temp);
                }
            }
        }
    }   // end of bubblesort() class

    public static void print_dashes(char c, int n){
        for(int i = 0; i < n; i++){
            if(i == (n-9)){
                System.out.print("|");
            }
            else{
                System.out.print("-");
            }

        }
    }   // end of print dashes method

    public static void noword_truncate(String str){
        StringBuilder sb = new StringBuilder(str);

        int i =0;
        while((i = str.indexOf(" ", i+50)) != -1){
            sb.replace(i, (i+1), "\n");
        }
        System.out.println(sb.toString());
    }

}   // end of class