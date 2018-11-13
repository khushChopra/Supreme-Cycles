package website1;

import java.util.ArrayList;

import org.springframework.util.DigestUtils;

import objectAndManagers.*;

public class calculations{
	public static int priceOfBoth(Customer user) {
		int ans =0;
		ArrayList<AccessoryCart> acart = AccessoryCartManager.allCustomerAccessoryCart(user.getNumber());
		ArrayList<CycleCart> ccart = CycleCartManager.allCustomerCycleCart(user.getNumber());
		Cycle_model temp = new Cycle_model();
		for(CycleCart a: ccart) {
			temp = Cycle_modelManager.readCycle_model(a.getCycle_code());
			ans = ans + temp.getPrice()*a.getQuantity();
		}
		Accessory temp1 = new Accessory();
		for(AccessoryCart b: acart) {
			temp1 = AccessoryManager.readAccessory(b.getAccessory_code());
			ans = ans + temp1.getPrice()*b.getQuantity();
		}	
		return ans;
	}
	
	public static int priceOfBoth(ArrayList<AccessoryCart> acart,ArrayList<CycleCart> ccart) {
		int ans =0;
		Cycle_model temp = new Cycle_model();
		for(CycleCart a: ccart) {
			temp = Cycle_modelManager.readCycle_model(a.getCycle_code());
			ans = ans + temp.getPrice()*a.getQuantity();
		}
		Accessory temp1 = new Accessory();
		for(AccessoryCart b: acart) {
			temp1 = AccessoryManager.readAccessory(b.getAccessory_code());
			ans = ans + temp1.getPrice()*b.getQuantity();
		}	
		return ans;
	}

	public static String requirements(Customer user) {
		ArrayList<AccessoryCart> acart = AccessoryCartManager.allCustomerAccessoryCart(user.getNumber());
		ArrayList<CycleCart> ccart = CycleCartManager.allCustomerCycleCart(user.getNumber());
		Cycle_model temp = new Cycle_model();
		String ans = "Cycles- \n";
		for(CycleCart a: ccart) {
			temp = Cycle_modelManager.readCycle_model(a.getCycle_code());
			ans = ans + " Cycle-code="+temp.getModel_code()+" Quantity=" + a.getQuantity()+".\n";
		}
		ans = ans + "Accessories- \n";
		Accessory temp1 = new Accessory();
		for(AccessoryCart b: acart) {
			temp1 = AccessoryManager.readAccessory(b.getAccessory_code());
			ans = ans + " Accessory-code="+temp1.getModel_code()+" Quantity=" + b.getQuantity()+".\n";
		}	
		return ans;
	}
	

	public static boolean requirements_fulfillable(Customer user) {
		ArrayList<AccessoryCart> acart = AccessoryCartManager.allCustomerAccessoryCart(user.getNumber());
		ArrayList<CycleCart> ccart = CycleCartManager.allCustomerCycleCart(user.getNumber());

		boolean ans = true;
		
		for(AccessoryCart a: acart) {
			Accessory temp = AccessoryManager.readAccessory(a.getAccessory_code());
			ans = ans && (temp.getQuantity()>=a.getQuantity());	
			System.out.println(a.getQuantity()+" <= "+temp.getQuantity());
		}
		System.out.println("");
		for(CycleCart a: ccart) {
			int inStock = Cycle_frameManager.numberOfCycle_frame(a.getCycle_code());
			ans = ans && (inStock>=a.getQuantity());
			System.out.println(a.getQuantity()+" <= "+inStock);
		}		
		return ans;
	}
	
	
	public static boolean checkPassword(String input) {
		input = DigestUtils.md5DigestAsHex(input.getBytes());
		if(input.contentEquals("0843e53286a02721e1d5392d271342aa")) {
			return true;
		}
		return false;		
	}
	
	
}