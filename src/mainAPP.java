import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class mainAPP {

	public static void main(String[] args) {
		
		//--- FASE 1 ---
		
		int bitllet_5=0, bitllet_10=0, bitllet_20=0, bitllet_50=0, bitllet_100=0, bitllet_200=0, bitllet_500=0;
		float total = 0;
		
		String[] menuDishes;
		float[] menuPrices;
		
		
		//--- FASE 2 ---
		
		HashMap<String, Float> menu = new HashMap<String, Float>();
		menu.put("ArrosCubana", 5.65f);
		menu.put("Amanida", 4.5f);
		menu.put("Hamburguesa", 5.0f);
		menu.put("Entremesos", 4.5f);
		menu.put("Parrillada verdures", 5.5f);
		menu.put("Canelons", 6.5f);
		menu.put("Entrecotte", 13.5f);
		menu.put("Lluç", 9.5f);
		menu.put("Pizza", 8.5f);
		
		// Initialize the arrays with menu dishes and prices
		menuDishes = new String[menu.size()];
		menuPrices = new float[menu.size()];
		
		{
			Iterator<Entry<String, Float>> menuIterator = menu.entrySet().iterator();
			for(int idx = 0 ; idx < menuDishes.length; idx++)
			{
				Map.Entry<String, Float> entry = (Map.Entry<String, Float>) menuIterator.next();
				menuDishes[idx] = entry.getKey();
				menuPrices[idx] = entry.getValue();
			}
		}

		// Ask ordered dishes
		
		{
			ArrayList<Integer> order = new ArrayList<Integer>();
			Scanner consoleInput = new Scanner(System.in);
			
			do
			{
				System.out.println("Menu dishes:\n-----------");
				for(int idx = 0; idx < menuDishes.length; idx++)
				{
					System.out.println(idx + ") " + menuDishes[idx]);
				}
				
				//List already ordered dishes.
				System.out.print("\nPer ara has demanat: ");
				

				for(Integer dish: order)
				{
					System.out.print(menuDishes[dish] + " , ");
				}
				
				// Ask for dish to add to order.
				System.out.print("\n\nQuins plats vol? Iniqui per número de plat: ");
				try
				{
					order.add((Integer) consoleInput.nextInt());
					// Check the number entered is in dishes range 
					if(order.get(order.size()-1) > menuDishes.length-1 || order.get(order.size()-1) < 0) 
					{
						order.remove(order.size()-1);
					}
				}catch(Exception e)
				{
					System.out.println("Si us plau entra el número de plat segons la llista.");
					consoleInput.nextLine();
				}
				
				//Ask if willing to order more dishes 
				System.out.print("Vols més plats? (0:no , 1:Sí): ");
	
			}while(consoleInput.next().contentEquals("1")); // Only continue ordering if 1 is entered.
			consoleInput.close();
			
			
			// --- Fase 3 ---
			
			System.out.println("\n\n Has demanat: ");
			Iterator<Integer> orderIterator = order.iterator();
			if(orderIterator.hasNext())
			{
				int idx = orderIterator.next();
				System.out.print(menuDishes[idx]);
				total += menuPrices[idx];

			}
			int dishIdx;
			while(orderIterator.hasNext())
			{
				dishIdx = orderIterator.next();
				System.out.print(" , " + menuDishes[dishIdx]);
				total += menuPrices[dishIdx];
			}
			System.out.println(".");
			System.out.println("Total = " + total + " €\n\n");
			
			float remainder = total; 
			while(remainder >= 5) // 5 is the minimum value bill
			{
				if (remainder >= 500)
				{
					remainder -= 500;
					bitllet_500++;
					continue;
				}
				if(remainder >= 200)
				{
					remainder -= 200;
					bitllet_200++;
					continue;
				}
				if(remainder >= 100)
				{
					remainder -= 100;
					bitllet_100++;
					continue;
				}
				if(remainder >= 50)
				{
					remainder -= 50;
					bitllet_50++;
					continue;
				}
				if(remainder >= 20)
				{
					remainder -= 20;
					bitllet_20++;
					continue;
				}
				if(remainder >= 10)
				{
					remainder -= 10;
					bitllet_10++;
					continue;
				}
				if(remainder >= 5)
				{
					remainder -= 5;
					bitllet_5++;
					continue;
				}
			}
			
			System.out.println("Pots pagar amb bitllets de:");
			System.out.println(" 500 €\t200 €\t100 €\t50 €\t20 €\t10 €\t5 €\t calderilla");
			System.out.println("  " + bitllet_500 + "\t " + bitllet_200 + "\t "+ 
									  bitllet_100 + "\t " + bitllet_50  + "\t" +
									  bitllet_20  + "\t"  + bitllet_10  + "\t" +
									  bitllet_5   + "\t    "+ remainder);
		}
		
		
		
	

	}

}
