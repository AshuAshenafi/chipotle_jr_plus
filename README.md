week two challenge: 
# Chipotle Jr Plus.
here is the Pseudocode:

Start
//INPUT
initialize Random class
declare ArrayList called "rice"
declare ArrayList called "meat"
declare ArrayList called "beans"
declare ArrayList called "salsa"
declare ArrayList called "veggies"
declare ArrayList called "cheese"
declare ArrayList called "guac"
declare ArrayList called "queso"
declare ArrayList called "sourcream"
declare ArrayList of ArrayList with name "all_ingredient" that store all the above nine arrays
populate ArrayList "all_ingredient" with the nine arrylists
populate the rice arraylist with the given components
populate the meat arraylist 
populate the beans arraylist 
populate the salsa arraylist 
populate the veggies arraylist 
populate the cheese arraylist 
populate the guac arraylist 
populate the queso arraylist 
populate the sourcream arraylist 
	FOR LOOP (index from zero to twenty five for twenty five burridos)
		declare variable for max range of random number
		declare variable for minimum range of random number
		declare and initialize variable for quantity of items that are neither "no" nor "none"
		declare a double variable for burrito final price

		declare Integer arraylist index_of_ingredients to store index of selected ones
		declare Integer arraylist to store index of burrito_components
		declare String burrito_for_cashier to list the components for calculation of the price
// PROCESS
		// generate random number between five and nine to decide howmany components are gonna be added
		initialize maximum random number range 10 so max range is not inclusive
		initialize minimum with value five
		declare integer variable to store random number which is how_many_ingredients are to be calculated
		declare integer variable index_of_which_ingredient to store random number which is index number for the above mentioned number of ingredients
			FOR LOOP (index is between zero and number of ingredients generated)
				initialize random maximum range to have 9 because our ingredient's index are bwtween 0 and 8
				initialize random number minimum range equal to zero
				generate and assign it to index_of_which_ingredient vairable
				// since the numbers to be generated have to be unique check if the newly generated value if already exists
					IF (index greater than zero) // to make sure the arraylist is not zero length to compare
						IF (the arraylist index_ingredients contains the generated number )
							decreament the index so that another number will be generated
						ELSE
							add the newly generated unique number to index_ingredients arraylist
						END IF
					ELSE
						// that means this is the first index number to be added
						add the generated index value to arraylist index_ingredients
					END IF
			END FOR LP
			FOR LOOP (index from zero to number of ingredients generated)
				initialize random number maximum range to take length of current ingredient arraylist size or array length
					IF (random number generated is zero) // if zero means we going to have negative number inside the array (wrong argument)
						increament maximum range by one
					END IF
				intialize minimum random number generated to be zero
				declare integer variable temp and assign it a random number
				add the value of temp variable to burrito_component arraylist
			END FOR LP
			FOR LOOP (index from zero to number of ingredients)
				declare a string variable  and assign burrito component names 
				add the value of temp to burrito for cashier arraylist
			END FOR LP
			FOR LOOP (index from zero to number of size of burrito for cashier arraylist)
				declare and initialzie false two boolean variables for both "no" and "none" burrito comp inputs
				assign one vaiable if an item has value "no" and the other one if the item has "none" string
					IF (either of the above two are true)
						do nothing
					ELSE
						increament value of Quantity for rate variable (qty_for_rate)
					END IF
			END FOR LP
		burrito_price is 3 plus qty times zero point five (burrito_price = 3 + (qty*0.5))
// OUTPUT
		print Burrito item number to start from one
			FOR LOOP (index from zero to arraylist length of burrito_for_cashier)
				IF (index is greater than zero)  // for comma to be printed after teh first one is printed
					print comma and single space char
				END IF
				print list of components from burrito for cashier arraylist
			END FOR LP
		print burrito price with dollar sign in its front
	END FOR LP
end



				
			
