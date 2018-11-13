package website1;

import objectAndManagers.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.SessionAttribute;
 


@Controller
@SessionAttributes("userObj")
public class RetailController{
	
	@ModelAttribute("userObj")
	public Customer setUpUser() {
		return new Customer();
	}
	
	@RequestMapping("/")
	public ModelAndView welcome(@ModelAttribute("userObj") Customer userObj) {
		if(!userObj.empty()) {
			ModelAndView error = new ModelAndView("redirect:/shop");
			return error;
		}
		ModelAndView model = new ModelAndView("a.welcome_page");
		return model;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("userObj") Customer userObj) {
		if(!userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "Already logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("b.login");
		return model;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login_create(@ModelAttribute("user") Customer user,@ModelAttribute("userObj") Customer userObj) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("redirect:/shop");
		Customer searched = CustomerManager.readCustomer(user.getNumber(),user.getName());
		if(searched==null) {
			
			ModelAndView error = new ModelAndView("error");
			error.addObject("userObj",new Customer());
			error.addObject("message", "No such user found");
			return error;
		}
		else {
			model.addObject("userObj", searched);
			return model;	
		}	
	}

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView register(@ModelAttribute("userObj") Customer userObj) {
		if(!userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "Already logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("c.register");
		return model;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register_create(@ModelAttribute("user") Customer user,@SessionAttribute("userObj") Customer userObj) {
		if(user.getNumber()=="") {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "error ");
			return error;
		}
		if(!userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "Already logged in ");
			return error;
		}
		Customer searched = CustomerManager.readCustomer(user.getNumber());
		if(searched!=null) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "Already exists ");
			return error;
		}
		ModelAndView model = new ModelAndView("redirect:/shop");
		CustomerManager.createCustomer(user);
		model.addObject("userObj", user);
		return model;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(@ModelAttribute("userObj") Customer userObj) {
		ModelAndView model = new ModelAndView("redirect:/");
		model.addObject("userObj",new Customer());
		return model;
	}

	@RequestMapping(value="/shop")
	public ModelAndView shop(@ModelAttribute("userObj") Customer userObj) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}

		ArrayList<Accessory> atemp = AccessoryManager.allAccessory();
		ArrayList<Cycle_model> ctemp = Cycle_modelManager.allCycle_model();
		ModelAndView model = new ModelAndView("d.shop");
		model.addObject("AccessoryList", atemp);
		model.addObject("Cycle_modelList", ctemp);
		return model;
	}

	@RequestMapping(value="/accessory")
	public ModelAndView Accessorys(@ModelAttribute("userObj") Customer userObj) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}

		ModelAndView model = new ModelAndView("g.allAccessory");
		model.addObject("list", AccessoryManager.allAccessory());
		return model;
	}
	
	@RequestMapping(value="/accessory/{model_code}")
	public ModelAndView AccessoryDetail(@ModelAttribute("userObj") Customer userObj,@PathVariable("model_code") String model_code) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}

		Accessory atemp = AccessoryManager.readAccessory(model_code);
		ModelAndView model = new ModelAndView("e.accessoryDetail");
		model.addObject("item", atemp);
		return model;
	}

	@RequestMapping(value="/cycle_model")
	public ModelAndView Cycle_model(@ModelAttribute("userObj") Customer userObj) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}

		ModelAndView model = new ModelAndView("h.allCycles");
		model.addObject("list", Cycle_modelManager.allCycle_model());
		return model;
	}

	@RequestMapping(value="/cycle_model/{model_code}")
	public ModelAndView Cycle_modelDetail(@ModelAttribute("userObj") Customer userObj,@PathVariable("model_code") String model_code) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}

		Cycle_model atemp = Cycle_modelManager.readCycle_model(model_code);
		ModelAndView model = new ModelAndView("f.cycle_modelDetail");
		model.addObject("item", atemp);
		return model;
	}

	@RequestMapping(value="/addCycletoCart/{model_code}", method=RequestMethod.POST)
	public ModelAndView addCycleToCart(@ModelAttribute("userObj") Customer userObj,@PathVariable("model_code") String model_code,@RequestParam("quantity") int quantity) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}
		
		CycleCart temp = new CycleCart();
		temp.setCustomer_number(userObj.getNumber());
		temp.setCycle_code(model_code);
		temp.setQuantity(quantity);
		CycleCartManager.createCycleCart(temp);
		ModelAndView model = new ModelAndView("redirect:/carts");
		return model;
	}


	@RequestMapping(value="/deleteCycleFromCart/{model_code}", method=RequestMethod.GET)
	public ModelAndView deleteCycleFromCart(@ModelAttribute("userObj") Customer userObj,@PathVariable("model_code") String model_code) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}
		
		CycleCart temp = new CycleCart();
		temp.setCustomer_number(userObj.getNumber());
		temp.setCycle_code(model_code);
		temp.setQuantity(0);
		CycleCartManager.createCycleCart(temp);
		ModelAndView model = new ModelAndView("redirect:/carts");
		return model;
	}

	@RequestMapping(value="/addAccessorytoCart/{model_code}", method=RequestMethod.POST)
	public ModelAndView addAccessoryToCart(@ModelAttribute("userObj") Customer userObj,@PathVariable("model_code") String model_code,@RequestParam("quantity") int quantity) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}
		
		AccessoryCart temp = new AccessoryCart();
		temp.setCustomer_number(userObj.getNumber());
		temp.setAccessory_code(model_code);
		temp.setQuantity(quantity);
		AccessoryCartManager.createAccessoryCart(temp);
		ModelAndView model = new ModelAndView("redirect:/carts");
		return model;
	}

	@RequestMapping(value="/deleteAccessoryFromCart/{model_code}", method=RequestMethod.GET)
	public ModelAndView deleteAccessoryfromCart(@ModelAttribute("userObj") Customer userObj,@PathVariable("model_code") String model_code) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}
		
		AccessoryCart temp = new AccessoryCart();
		temp.setCustomer_number(userObj.getNumber());
		temp.setAccessory_code(model_code);
		temp.setQuantity(0);
		AccessoryCartManager.createAccessoryCart(temp);
		ModelAndView model = new ModelAndView("redirect:/carts");
		return model;
	}

	@RequestMapping(value="/carts", method=RequestMethod.GET)
	public ModelAndView carts(@ModelAttribute("userObj") Customer userObj) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("i.cart");
		ArrayList<AccessoryCart> acart = AccessoryCartManager.allCustomerAccessoryCart(userObj.getNumber());
		ArrayList<CycleCart> ccart = CycleCartManager.allCustomerCycleCart(userObj.getNumber());
		int total = calculations.priceOfBoth(userObj);
		model.addObject("AccessoryCart", acart);

		model.addObject("fixed", Purchase_recordManager.all_closedPurchase_record());
		model.addObject("CycleCart", ccart);
		model.addObject("total", total);
		ArrayList<Cycle_model> temp = Cycle_modelManager.allCycle_model();
		HashMap<String, Cycle_model> cm = new HashMap<String, Cycle_model>();
		for(Cycle_model a: temp) {
			cm.put(a.getModel_code(),a);
		}
		ArrayList<Accessory> temp2 = AccessoryManager.allAccessory();
		HashMap<String, Accessory> am = new HashMap<String, Accessory>();
		for(Accessory a: temp2) {
			am.put(a.getModel_code(),a);
		}
		
		model.addObject("cm",cm);
		model.addObject("am",am);
		model.addObject("tlist", TransporterManager.allTransporter());
		return model;
	}	
	
	@RequestMapping(value="/carts", method=RequestMethod.POST)
	public ModelAndView checkout(@ModelAttribute("userObj") Customer userObj, @RequestParam("transportservice_id") String transportservice_id, @RequestParam("temp_address") String address) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}		


		if(!calculations.requirements_fulfillable(userObj)) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "Currently out of stock");
			return error;
		}
		
		
		// generate transaction_log
		Transaction_log tl = new Transaction_log();
		tl.setType("Credit");
		tl.setDetails("From Customer "+userObj.getName()+" - "+userObj.getNumber());
		tl.setAmount(calculations.priceOfBoth(userObj));
		int id = Transaction_logManager.createTransaction_log(tl);
		tl = Transaction_logManager.getTransaction_log(id);
		// generate invoice
		Invoice ti = new Invoice();
		ti.setAddress(address);
		ti.setAmount(tl.getAmount());
		ti.setId(id);
		ti.setCreation(tl.getcreation());
		ti.setCustomer_number(userObj.getNumber());
		ti.setTransportservice_id(transportservice_id);
		InvoiceManager.createInvoice(ti);
		// allot accessories
		ArrayList<AccessoryCart> acart = AccessoryCartManager.allCustomerAccessoryCart(userObj.getNumber());
		for(AccessoryCart a: acart) {
			Invoice_accessory temp = new Invoice_accessory();
			temp.setInvoice_id(id);
			temp.setModel_code(a.getAccessory_code());
			temp.setQuantity(a.getQuantity());
			Invoice_accessoryManager.createInvoice_accessory(temp);
		}
		
		// subtract from stock
		AccessoryManager.subtractStockAccessory(acart);
		
		// delete cart
		AccessoryCartManager.deleteallAccessoryCart(userObj);
		
		
		

		// allot cycle frames
		ArrayList<CycleCart> ccart = CycleCartManager.allCustomerCycleCart(userObj.getNumber());
		
		for(CycleCart a:ccart) {
			ArrayList<Cycle_frame> tempList = Cycle_frameManager.allCycle_frame(a.getCycle_code());
			for(Cycle_frame b: tempList) {
				if(a.getQuantity()<=0) {
					break;
				}
				a.setQuantity(a.getQuantity()-1);
				Invoice_frame temp = new Invoice_frame();
				temp.setFrame_number(b.getFrame_number());
				temp.setInvoice_id(id);
				temp.setModel_code(a.getCycle_code());
				Invoice_frameManager.createInvoice_frame(temp);
			}
		}
		
		// delete cart
		CycleCartManager.deleteallCycleCart(userObj);
				
		
		ModelAndView model = new ModelAndView("redirect:/invoice");
		return model;
	}


	@RequestMapping(value="/invoice")
	public ModelAndView allInvoice(@ModelAttribute("userObj") Customer userObj) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("j.invoices");
		model.addObject("list",InvoiceManager.allInvoice(userObj));
		return model;
	}	
	
	

	@RequestMapping(value="/invoice/{id}")
	public ModelAndView allInvoice(@ModelAttribute("userObj") Customer userObj, @PathVariable("id") String id) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("k.invoiceDetail");
		ArrayList<Cycle_model> temp = Cycle_modelManager.allCycle_model();
		HashMap<String, Cycle_model> cm = new HashMap<String, Cycle_model>();
		for(Cycle_model a: temp) {
			cm.put(a.getModel_code(),a);
		}
		ArrayList<Accessory> temp2 = AccessoryManager.allAccessory();
		HashMap<String, Accessory> am = new HashMap<String, Accessory>();
		for(Accessory a: temp2) {
			am.put(a.getModel_code(),a);
		}
		
		model.addObject("cm",cm);
		model.addObject("am",am);
		model.addObject("clist",Invoice_frameManager.allInvoice_frame(Integer.parseInt(id)));
		model.addObject("alist",Invoice_accessoryManager.allInvoice_accessory(Integer.parseInt(id)));
		Invoice temp3 = InvoiceManager.readInvoice(Integer.parseInt(id));
		model.addObject("inv",temp3);
		return model;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView search(@ModelAttribute("userObj") Customer userObj,@RequestParam("query") String query) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			return error;
		}

		ArrayList<Accessory> atemp = AccessoryManager.allAccessory();
		ArrayList<Cycle_model> ctemp = Cycle_modelManager.allCycle_model();
		
		String[] words = query.toLowerCase().split(" ");
		
		ArrayList<Accessory> aatemp = new ArrayList<Accessory>();
		ArrayList<Cycle_model> cctemp = new ArrayList<Cycle_model>();
		for(Accessory b: atemp) {
			boolean flag =false;
			for(String word: words) {
				String l = b.getModel_name(),q = word;
				l=l.toLowerCase();
				q=q.toLowerCase();
				if(l.contains(q)) {
					flag = true;
				}
				l = b.getBrand_name();
				l=l.toLowerCase();
				if(l.contains(q)) {
					flag = true;
				}
				l = b.getType();
				l=l.toLowerCase();
				if(l.contains(q)) {
					flag = true;
				}
			}
			if(flag) {
				aatemp.add(b);
			}
		}

		for(Cycle_model b: ctemp) {
			boolean flag =false;
			for(String word: words) {
				String l = b.getModel_name(),q = word;
				q=q.toLowerCase();
				l=l.toLowerCase();
				
				if(l.contains(q)) {
					flag = true;
				}
				l = b.getBrand_name();
				l=l.toLowerCase();
				
				if(l.contains(q)) {
					flag = true;
				}
				l = b.getType();
				l=l.toLowerCase();
				if(l.contains(q)) {
					flag = true;
				}
			}
			if(flag) {
				cctemp.add(b);
			}
		}
		ModelAndView model = new ModelAndView("d.shop");
		model.addObject("AccessoryList", aatemp);
		model.addObject("Cycle_modelList", cctemp);
		return model;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/neverPossible2")
	public ModelAndView xt(@ModelAttribute("userObj") Customer userObj) {
		if(userObj.empty()) {
			ModelAndView error = new ModelAndView("error");
			error.addObject("message", "not logged in");
			//return error;
		}
		
		Accessory temp = new Accessory();
		temp.setModel_code("FRX21470S00");
		temp.setModel_name("Fluid 2");
		temp.setBrand_name("Firefox");
		temp.setColor("Black");
		temp.setType("Trainer");
		temp.setAccessory_size("Free");
		temp.setPrice(32500);
		temp.setQuantity(0);
		temp.setImage("https://i.imgur.com/WkuqJLt.jpg");
		
		AccessoryManager.createAccessory(temp);
		
		
		ModelAndView model = new ModelAndView("redirect:/xtra");
		model.addObject("list", temp);
		return model;
	}
	
	@RequestMapping(value="/neverPossible")
	public ModelAndView x() {   
		
		
		Cycle_model temp = new Cycle_model();
		temp.setModel_code("FRX10245S19");
		temp.setModel_name("Nuke 29");
		temp.setBrand_name("Firefox");
		temp.setColor("Red");
		temp.setType("MTB");
		temp.setKit_details("Shifters: SHIMANO ALTUS , 3 X 9 speed\r\n" + 
				"		Front Deraileur: SHIMANO ALTUS\r\n" + 
				"		Rear Deraileur: SHIMANO M370 ALTUS\r\n" + 
				"		Wheels: Alex Alloy 32H Tubeless Ready Double Wall Rims\r\n" + 
				"		Tires: KENDA K1027, 29 X 2.1 inch\r\n" + 
				"		Brakeset: TEKTRO M285 hydraulic disc brake");
		temp.setFrame_size("17.5 inch");
		temp.setWeight("16 kg / 35.2 lb");
		temp.setMaterial("Aluminium");
		temp.setPrice(32500);
		temp.setImage("https://i.imgur.com/hW6yHJe.jpg");
		Cycle_modelManager.updateCycle_model(temp);
		
		
		
		
		
		ModelAndView model = new ModelAndView("tr");
		//model.addObject("list", temp);
		return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}