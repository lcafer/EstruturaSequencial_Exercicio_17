package EstruturaSequencial_Exercicio_17;
import java.util.Scanner;

public class InkShop {
	static float SQUARE_METERS_PER_LITERS = 6.0f;
	static float CAN_PRICE = 80.00f;
	static float GALLON_PRICE = 25.00f;
	static int INK_CAN_LITERS = 18;
	static float INK_GALLON_LITERS = 3.6f;
	static String menuOptions[] = {"[1] - Comprar apenas latas de 18 litros", "[2] - Comprar apenas galões de 3,6 litros", "[3] - Misturar latas e galões. Acrescente 10% de folga."};
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Qual o tamanho da área em metros quadrados a ser pintada?");
		String areaInput = userInput.nextLine();
		
		for(int i = 0; i < menuOptions.length; i++) {
			System.out.println(menuOptions[i]);	
		}
		
		String optionInput = userInput.nextLine();
		float litersQuantity = Float.parseFloat(areaInput)/SQUARE_METERS_PER_LITERS;
		
		if(optionInput.matches("[1-3]")) {
			switch (optionInput){
			case "1":	
				int inkCan = (int) Math.ceil(litersQuantity / INK_CAN_LITERS);
				float can_price = inkCan*CAN_PRICE;
				System.out.println("Você deverá comprar "+inkCan+" lata(s) de tinta. Ficara no valor de: R$ " + can_price);
				break;
			case "2":
				int inkGallon = (int) Math.ceil(litersQuantity / INK_GALLON_LITERS);
				float gallon_price = inkGallon*GALLON_PRICE;
				System.out.println("Você deverá comprar "+inkGallon+" lata(s) de tinta. Ficara no valor de: R$ " + gallon_price);
				break;
			case "3":
				int gallon = 0;
				int can = 0;
				litersQuantity = litersQuantity * (float) 1.10;
				System.out.println(litersQuantity);
				if(litersQuantity >= 18.0) {
					can = (int) litersQuantity / INK_CAN_LITERS;
				float diference = litersQuantity - (can*INK_CAN_LITERS); 
					gallon = (int) Math.ceil(diference / INK_GALLON_LITERS);
				} else { 
					gallon = (int) Math.ceil(litersQuantity / INK_GALLON_LITERS);
				}
				float canWithGallonPrice = (can*CAN_PRICE) + (gallon*GALLON_PRICE);
				System.out.print("Você deverá comprar "+can+" lata(s) e " + gallon + " galões de tinta. Ficara no valor de: R$ " + canWithGallonPrice);
				break;
			}
		} else {
			System.out.println("GAME OVER");
		}
		userInput.close();
		System.exit(0);
	}
}
