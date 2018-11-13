package website1;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import objectAndManagers.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
 


@Controller
@SessionAttributes("ownerObj")
public class AdminController{
	
	@ModelAttribute("ownerObj")
	public Owner setUpOwner() {
		return new Owner();
	}
	
	@RequestMapping("/owner")
	public ModelAndView welcome(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(!ownerObj.empty()) {
			ModelAndView error = new ModelAndView("redirect:/owner/main");
			error.addObject("message", "Already logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("z.a.welcome");
		model.addObject("ownerObj", ownerObj);
		return model;
	}

	@RequestMapping(value="/owner/login", method=RequestMethod.GET)
	public ModelAndView Ownerlogin(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(!ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "Already logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.b.login");
		return model;
	}
	
	@RequestMapping(value="/owner/login", method=RequestMethod.POST)
	public ModelAndView Ologin_create(@RequestParam("cname") String name, @RequestParam("cnumber") String number, @RequestParam("key") String key, @ModelAttribute("ownerObj") Owner ownerObj) {
		Owner candidate= new Owner();
		candidate.setOName(name);
		candidate.setONumber(number);
		if(!calculations.checkPassword(key)) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "bad key");
			return error;
		}
		
		ModelAndView model = new ModelAndView("redirect:/owner/main");
		boolean searched = OwnerManager.getOwner(candidate);
		if(searched==false){
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "No such user found");
			return error;
		}		
		model.addObject("ownerObj", candidate);
		return model;	
		
	}
	
	@RequestMapping("/owner/logout")
	public ModelAndView logout(@ModelAttribute("userObj") Customer userObj) {
		ModelAndView model = new ModelAndView("redirect:/owner");
		model.addObject("ownerObj",new Owner());
		return model;
	}
	
	@RequestMapping("/owner/main")
	public ModelAndView helloWorld( @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.c.mainpage");
		
		
		model.addObject("message","");
		return model;
	}

	@RequestMapping(value="/owner/distributor", method=RequestMethod.GET)
	public ModelAndView viewDistributors(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.d.allDistributor");
		model.addObject("list", DistributorManager.allDistributor());
		return model;
	}

	@RequestMapping(value="/owner/customer", method=RequestMethod.GET)
	public ModelAndView viewcustomers(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.d.allCustomer");
		model.addObject("list", CustomerManager.allCustomer());
		return model;
	}

	@RequestMapping(value="/owner/distributor/{dis_num}", method=RequestMethod.GET)
	public ModelAndView editDistributors(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("dis_num") String dis_num) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.g.Distributorform");
		model.addObject("item", DistributorManager.getDistributor(dis_num));
		return model;
	}

	@RequestMapping(value="/owner/distributor/{dis_num}/del", method=RequestMethod.GET)
	public ModelAndView delDistributors(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("dis_num") String dis_num) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		DistributorManager.deleteDistributor(DistributorManager.getDistributor(dis_num));
		ModelAndView model = new ModelAndView("redirect:/owner/distributor");
		return model;
	}
	
	@RequestMapping(value="/owner/distributor/{dis_num}", method=RequestMethod.POST)
	public ModelAndView editDistributorsProcess(@ModelAttribute("ownerObj") Owner ownerObj,@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("number") String number) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Distributor temp = new Distributor();
		temp.setAddress(address);
		temp.setName(name);
		temp.setNumber(number);
		DistributorManager.updateDistributor(temp);
		ModelAndView model = new ModelAndView("redirect:/owner/distributor");
		return model;
	}

	@RequestMapping(value="/owner/employee", method=RequestMethod.GET)
	public ModelAndView viewEmployees(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.d.allEmployee");
		model.addObject("list", EmployeeManager.allEmployee());
		return model;
	}


	@RequestMapping(value="/owner/employee/{emp_num}", method=RequestMethod.GET)
	public ModelAndView editEmployees(@ModelAttribute("ownerObj") Owner ownerObj , @PathVariable("emp_num") String emp_num) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.g.Employeeform");
		model.addObject("item",EmployeeManager.getEmployee(emp_num));
		return model;
	}
	
	@RequestMapping(value="/owner/employee/{emp_num}/del", method=RequestMethod.GET)
	public ModelAndView delEmployees(@ModelAttribute("ownerObj") Owner ownerObj , @PathVariable("emp_num") String emp_num) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		EmployeeManager.deleteeEmployee(EmployeeManager.getEmployee(emp_num));
		ModelAndView model = new ModelAndView("redirect:/owner/employee");
		return model;
	}


	@RequestMapping(value="/owner/employee/{emp_num}", method=RequestMethod.POST)
	public ModelAndView editEmployeesProcess(@ModelAttribute("ownerObj") Owner ownerObj , @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("number") String number) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Employee temp = new Employee();
		temp.setAddress(address);
		temp.setName(name);
		temp.setNumber(number);
		EmployeeManager.updateEmployee(temp);
		ModelAndView model = new ModelAndView("redirect:/owner/employee");
		return model;
	}

	
	

	@RequestMapping(value="/owner/transporter", method=RequestMethod.GET)
	public ModelAndView viewTransporters(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.d.allTransporter");
		model.addObject("list", TransporterManager.allTransporter());
		return model;
	}

	@RequestMapping(value="/owner/transporter/{t_num}", method=RequestMethod.GET)
	public ModelAndView editTransporters(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("t_num") String t_num) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("z.g.Transporterform");
		model.addObject("item", TransporterManager.getTransporter(t_num));
		return model;
	}

	@RequestMapping(value="/owner/transporter/{t_num}/del", method=RequestMethod.GET)
	public ModelAndView delTransporters(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("t_num") String t_num) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		TransporterManager.deleteTransporter(TransporterManager.getTransporter(t_num));
		ModelAndView model = new ModelAndView("redirect:/owner/transporter");
		return model;
	}

	@RequestMapping(value="/owner/transporter/{t_num}", method=RequestMethod.POST)
	public ModelAndView editTransportersProcess(@ModelAttribute("ownerObj") Owner ownerObj, @RequestParam("area") String area, @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("number") String number) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Transporter temp = new Transporter();
		temp.setAddress(address);
		temp.setArea(area);
		temp.setName(name);
		temp.setNumber(number);
		TransporterManager.updateTransporter(temp);
		ModelAndView model = new ModelAndView("redirect:/owner/transporter");
		return model;
	}
	
	
	

	@RequestMapping(value="/owner/transaction_log", method=RequestMethod.GET)
	public ModelAndView viewTransaction_logs(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.d.allTransaction_log");
		model.addObject("list", Transaction_logManager.allTransaction_log());
		return model;
	}
	
	@RequestMapping(value="/owner/salary", method=RequestMethod.GET)
	public ModelAndView viewSalary(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.d.allSalary");
		model.addObject("list", SalaryManager.allSalary());
		model.addObject("elist", EmployeeManager.allEmployee());
		return model;
	}
	
	@RequestMapping(value="/owner/purchase_record", method=RequestMethod.GET)
	public ModelAndView viewPurchase_record(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.d.allPurchase_record");
		model.addObject("list", Purchase_recordManager.allPurchase_record());
		model.addObject("dlist", DistributorManager.allDistributor());
		return model;
	}

	@RequestMapping(value="/owner/purchase_record/{purchase_recordId}", method=RequestMethod.GET)
	public ModelAndView viewPurchase_recordDetail(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("purchase_recordId") String purchase_recordId) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.e.detailPurchase_record");

		model.addObject("clist", Cycle_frameManager.allCycle_frame(Integer.parseInt(purchase_recordId)));
		model.addObject("cmlist", Cycle_modelManager.allCycle_model());
		model.addObject("amlist", AccessoryManager.allAccessory());
		model.addObject("alist", Purchase_accessoryManager.allPurchase_accessory(Integer.parseInt(purchase_recordId)));
		model.addObject("pr", Purchase_recordManager.readPurchase_record(Integer.parseInt(purchase_recordId)));
		
		
		return model;
	}


	@RequestMapping(value="/owner/purchase_record/{model_code}/{frame_number}/{pr_id}/deleteCycle", method=RequestMethod.GET)
	public ModelAndView deleteCyclefromPurchase_recordDetail(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("frame_number") String frame_number, @PathVariable("pr_id") String pr_id, @PathVariable("model_code") String model_code) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Cycle_frame temp = new Cycle_frame();
		temp.setFrame_number(frame_number);
		temp.setModel_code(model_code);
		temp.setPurchase_id(Integer.parseInt(pr_id));
		Cycle_frameManager.deleteCycle_frame(temp);
		ModelAndView model = new ModelAndView("redirect:/owner/purchase_record/"+pr_id);
		model.addObject("clist", Cycle_frameManager.allCycle_frame(Integer.parseInt(pr_id)));
		model.addObject("cmlist", Cycle_modelManager.allCycle_model());
		model.addObject("amlist", AccessoryManager.allAccessory());
		model.addObject("alist", Purchase_accessoryManager.allPurchase_accessory(Integer.parseInt(pr_id)));
		model.addObject("pr", Purchase_recordManager.readPurchase_record(Integer.parseInt(pr_id)));
		return model;
	}


	@RequestMapping(value="/owner/purchase_record/{model_code}/{pr_id}/deleteAccessory", method=RequestMethod.GET)
	public ModelAndView deleteAccessoryfromPurchase_recordDetail(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("pr_id") String pr_id, @PathVariable("model_code") String model_code) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Purchase_accessory temp = new Purchase_accessory();
		temp.setModel_code(model_code);
		temp.setPurchase_id(Integer.parseInt(pr_id));
		Purchase_accessoryManager.deletePurchase_accessory(temp);
		ModelAndView model = new ModelAndView("redirect:/owner/purchase_record/"+pr_id);
		model.addObject("clist", Cycle_frameManager.allCycle_frame(Integer.parseInt(pr_id)));
		model.addObject("cmlist", Cycle_modelManager.allCycle_model());
		model.addObject("amlist", AccessoryManager.allAccessory());
		model.addObject("alist", Purchase_accessoryManager.allPurchase_accessory(Integer.parseInt(pr_id)));
		model.addObject("pr", Purchase_recordManager.readPurchase_record(Integer.parseInt(pr_id)));
		return model;
	}

	@RequestMapping(value="/owner/purchase_record/{pr_id}/lock", method=RequestMethod.GET)
	public ModelAndView lockPurchase_recordDetail(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("pr_id") String pr_id) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Purchase_recordManager.closePurchase_record(Purchase_recordManager.readPurchase_record(Integer.parseInt(pr_id)));
		
		// add quantities to accessory in stock
		

	//	model.addObject("alist", Purchase_accessoryManager.allPurchase_accessory(Integer.parseInt(pr_id)));
		//model.addObject("amlist", AccessoryManager.allAccessory());
		AccessoryManager.addStockAccessory(Purchase_accessoryManager.allPurchase_accessory(Integer.parseInt(pr_id)));
		
		
		ModelAndView model = new ModelAndView("redirect:/owner/purchase_record/"+pr_id);
		model.addObject("clist", Cycle_frameManager.allCycle_frame(Integer.parseInt(pr_id)));
		model.addObject("cmlist", Cycle_modelManager.allCycle_model());
		model.addObject("amlist", AccessoryManager.allAccessory());
		model.addObject("alist", Purchase_accessoryManager.allPurchase_accessory(Integer.parseInt(pr_id)));
		model.addObject("pr", Purchase_recordManager.readPurchase_record(Integer.parseInt(pr_id)));
		return model;
	}
	
	@RequestMapping(value="/owner/invoice", method=RequestMethod.GET)
	public ModelAndView viewInvoice(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		ModelAndView model = new ModelAndView("z.d.allInvoice");
		model.addObject("list", InvoiceManager.allInvoice());
		return model;
	}

	@RequestMapping(value="/owner/invoice/{id}")
	public ModelAndView allInvoice(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("id") String id) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("z.f.invoiceDetail");
		model.addObject("clist",Invoice_frameManager.allInvoice_frame(Integer.parseInt(id)));
		model.addObject("alist",Invoice_accessoryManager.allInvoice_accessory(Integer.parseInt(id)));
		Invoice temp = InvoiceManager.readInvoice(Integer.parseInt(id));
		model.addObject("inv",temp);
		return model;
	}	

	
	// add cycle page, cycle details page, adding and removing cycle
	// dame for accessories
	@RequestMapping(value="/owner/cycle")
	public ModelAndView allcycle(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		HashMap<String, Integer> stock = new HashMap<String, Integer>();
		ModelAndView model = new ModelAndView("z.d.allCycle");
		for(Cycle_model a:Cycle_modelManager.allCycle_model()) {
			stock.put(a.getModel_code(), Cycle_frameManager.numberOfCycle_frame(a.getModel_code()));
		}
		model.addObject("stock",stock);
		model.addObject("clist",Cycle_modelManager.allCycle_model());
		return model;
	}	
	

	@RequestMapping(value="/owner/cycle/{model_code}")
	public ModelAndView detailcycle(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("model_code") String model_code) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("z.e.detailCycle");
		model.addObject("item",Cycle_modelManager.readCycle_model(model_code));
		return model;
	}	

	@RequestMapping(value="/owner/editCycle/{model_code}", method=RequestMethod.GET)
	public ModelAndView editcycle(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("model_code") String model_code) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("z.g.cycleform");
		model.addObject("item",Cycle_modelManager.readCycle_model(model_code));
		return model;
	}	
	

	@RequestMapping(value="/owner/cycle/{model_code}/delete")
	public ModelAndView deletecycle(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("model_code") String model_code) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Cycle_modelManager.deleteCycle_model(model_code);
		ModelAndView model = new ModelAndView("redirect:/owner/cycle");
		model.addObject("item",Cycle_modelManager.readCycle_model(model_code));
		return model;
	}	
	
	//accessory
	//1-1-68

	@RequestMapping(value="/owner/accessory")
	public ModelAndView allaccessory(@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("z.d.allAccessory");
		model.addObject("alist",AccessoryManager.allAccessory());
		return model;
	}	
	

	@RequestMapping(value="/owner/accessory/{model_code}")
	public ModelAndView detailaccessory(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("model_code") String model_code) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("z.e.detailAccessory");
		model.addObject("item",AccessoryManager.readAccessory(model_code));
		return model;
	}	

	@RequestMapping(value="/owner/editAccessory/{model_code}", method=RequestMethod.GET)
	public ModelAndView editAccessory(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("model_code") String model_code) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		
		ModelAndView model = new ModelAndView("z.g.Accessoryform");
		model.addObject("item",AccessoryManager.readAccessory(model_code));
		return model;
	}	
	

	@RequestMapping(value="/owner/accessory/{model_code}/delete")
	public ModelAndView deleteaccessory(@ModelAttribute("ownerObj") Owner ownerObj, @PathVariable("model_code") String model_code) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		AccessoryManager.deleteAccessory(model_code);
		ModelAndView model = new ModelAndView("redirect:/owner/accessory");
		return model;
	}	
	
	
	
	///    POSTs
	

	@RequestMapping(value="/owner/editCycle/{model_code}", method=RequestMethod.POST)
	public ModelAndView editcycleProcess(@ModelAttribute("ownerObj") Owner ownerObj , @ModelAttribute("cycle_model") Cycle_model new_model ) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Cycle_modelManager.updateCycle_model(new_model);
		ModelAndView model = new ModelAndView("redirect:/owner/cycle/"+new_model.getModel_code());
		return model;
	}
	
	@RequestMapping(value="/owner/cycle", method=RequestMethod.POST)
	public ModelAndView addcycle(@ModelAttribute("ownerObj") Owner ownerObj, @ModelAttribute("cycle_model") Cycle_model new_model ) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Cycle_modelManager.createCycle_model(new_model);
		ModelAndView model = new ModelAndView("redirect:/owner/cycle");
		model.addObject("clist",Cycle_modelManager.allCycle_model());
		return model;
	}	

	
	@RequestMapping(value="/owner/accessory", method=RequestMethod.POST)
	public ModelAndView addcycle(@ModelAttribute("ownerObj") Owner ownerObj, @ModelAttribute("accessory") Accessory accessory ) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		AccessoryManager.createAccessory(accessory);
		ModelAndView model = new ModelAndView("redirect:/owner/accessory");
		model.addObject("alist",AccessoryManager.allAccessory());
		return model;
	}	
	

	@RequestMapping(value="/owner/editAccessory/{model_code}", method=RequestMethod.POST)
	public ModelAndView addAccessoryProcess(@ModelAttribute("ownerObj") Owner ownerObj,  @ModelAttribute("accessory") Accessory accessory ) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		AccessoryManager.updateAccessory(accessory);
		ModelAndView model = new ModelAndView("redirect:/owner/accessory/");
		return model;
	}	
	

	@RequestMapping(value="/owner/distributor", method=RequestMethod.POST)
	public ModelAndView addDistributors(@RequestParam("name") String name, @RequestParam("number") String number, @RequestParam("address") String address,@ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}

		Distributor temp = new Distributor();
		temp.setAddress(address);
		temp.setName(name);
		temp.setNumber(number);
		DistributorManager.createDistributor(temp);
		ModelAndView model = new ModelAndView("redirect:/owner/distributor");
		model.addObject("list", DistributorManager.allDistributor());
		return model;
	}


	@RequestMapping(value="/owner/employee", method=RequestMethod.POST)
	public ModelAndView addEmployees(@RequestParam("name") String name, @RequestParam("number") String number, @RequestParam("address") String address, @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}

		Employee temp = new Employee();
		temp.setAddress(address);
		temp.setName(name);
		temp.setNumber(number);
		EmployeeManager.createEmployee(temp);
		ModelAndView model = new ModelAndView("redirect:/owner/employee");
		model.addObject("list", EmployeeManager.allEmployee());
		return model;
	}


	@RequestMapping(value="/owner/transporter", method=RequestMethod.POST)
	public ModelAndView addTransporters(@RequestParam("name") String name,@RequestParam("area") String area, @RequestParam("number") String number, @RequestParam("address") String address, @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Transporter temp = new Transporter();
		temp.setAddress(address);
		temp.setName(name);
		temp.setNumber(number);
		temp.setArea(area);
		TransporterManager.createTransporter(temp);
		ModelAndView model = new ModelAndView("redirect:/owner/transporter");
		model.addObject("list", TransporterManager.allTransporter());
		return model;
	}


	@RequestMapping(value="/owner/transaction_log", method=RequestMethod.POST)
	public ModelAndView addTransaction_logs(@RequestParam("details") String details, @RequestParam("amount") int amount, @RequestParam("type") String type, @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Transaction_log temp = new Transaction_log();
		temp.setDetails(details);
		temp.setType(type);
		temp.setAmount(amount);
		int t = Transaction_logManager.createTransaction_log(temp);
		System.out.println(t);
		ModelAndView model = new ModelAndView("redirect:/owner/transaction_log");
		model.addObject("list", TransporterManager.allTransporter());
		return model;
	}

	


	@RequestMapping(value="/owner/salary", method=RequestMethod.POST)
	public ModelAndView addSalary(@RequestParam("emp_num") String emp_num, @RequestParam("amount") int amount, @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Transaction_log tl = new Transaction_log();
		tl.setType("Debit");
		tl.setDetails("Salary to "+EmployeeManager.getEmployee(emp_num).getName()+" - "+emp_num);
		tl.setAmount(amount);
		int id = Transaction_logManager.createTransaction_log(tl);
		tl = Transaction_logManager.getTransaction_log(id);
		
		Salary temp = new Salary();
		temp.setAmount(amount);
		temp.setCreation(tl.getcreation());
		temp.setEmp_num(emp_num);
		temp.setId(id);
		temp.setOwner_number(ownerObj.getONumber());
		SalaryManager.createSalary(temp);		
		
		ModelAndView model = new ModelAndView("redirect:/owner/salary");
		model.addObject("list", SalaryManager.allSalary());
		model.addObject("elist", EmployeeManager.allEmployee());
		return model;
	}


	@RequestMapping(value="/owner/purchase_record", method=RequestMethod.POST)
	public ModelAndView addPurchase_record(@RequestParam("dis_num") String dis_num, @RequestParam("amount") int amount, @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		
		
		Transaction_log tl = new Transaction_log();
		tl.setType("Debit");
		tl.setDetails("Purchase from "+DistributorManager.getDistributor(dis_num).getName()+" - "+dis_num);
		tl.setAmount(amount);
		int id = Transaction_logManager.createTransaction_log(tl);
		tl = Transaction_logManager.getTransaction_log(id);
		
		Purchase_record temp = new Purchase_record();
		temp.setAmount(amount);
		temp.setCreation(tl.getcreation());
		temp.setDis_num(dis_num);
		temp.setId(id);
		temp.setOwner_number(ownerObj.getONumber());
		Purchase_recordManager.createPurchase_record(temp);		
		
		ModelAndView model = new ModelAndView("redirect:/owner/purchase_record");
		model.addObject("list", Purchase_recordManager.allPurchase_record());
		model.addObject("dlist", DistributorManager.allDistributor());
		return model;
	}

	@RequestMapping(value="/owner/purchase_record/{purchase_recordId}/delete", method=RequestMethod.GET)
	public ModelAndView deletePurchase_record(@PathVariable("purchase_recordId") String purchase_recordId, @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}
		Purchase_recordManager.deletePurchase_record(Integer.parseInt(purchase_recordId));
		
		ModelAndView model = new ModelAndView("redirect:/owner/purchase_record");
		return model;
	}

	@RequestMapping(value="/owner/purchase_record/{purchase_recordId}/addCycle", method=RequestMethod.POST)
	public ModelAndView addCycletoPurchase_record(@RequestParam("model_code") String model_code, @RequestParam("frame_number") String frame_number, @PathVariable("purchase_recordId") String purchase_recordId, @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}

		Cycle_frame temp = new Cycle_frame();
		temp.setFrame_number(frame_number);
		temp.setModel_code(model_code);
		
		temp.setPurchase_id(Integer.parseInt(purchase_recordId));
		Cycle_frameManager.createCycle_frame(temp);
		
		ModelAndView model = new ModelAndView("redirect:/owner/purchase_record/"+purchase_recordId);
		model.addObject("clist", Cycle_frameManager.allCycle_frame(Integer.parseInt(purchase_recordId)));
		model.addObject("cmlist", Cycle_modelManager.allCycle_model());
		model.addObject("amlist", AccessoryManager.allAccessory());
		model.addObject("alist", Purchase_accessoryManager.allPurchase_accessory(Integer.parseInt(purchase_recordId)));
		model.addObject("pr", Purchase_recordManager.readPurchase_record(Integer.parseInt(purchase_recordId)));
		return model;
	}


	@RequestMapping(value="/owner/purchase_record/{purchase_recordId}/addAccessory", method=RequestMethod.POST)
	public ModelAndView addAccessorytoPurchase_record(@RequestParam("model_code") String model_code, @RequestParam("quantity") String quantity, @PathVariable("purchase_recordId") String purchase_recordId, @ModelAttribute("ownerObj") Owner ownerObj) {
		if(ownerObj.empty()) {
			ModelAndView error = new ModelAndView("zerror");
			error.addObject("message", "not logged in");
			return error;
		}

		Purchase_accessory temp = new Purchase_accessory();
		temp.setModel_code(model_code);
		temp.setPurchase_id(Integer.parseInt(purchase_recordId));
		temp.setQuantity(Integer.parseInt(quantity));
		
		Purchase_accessoryManager.createPurchase_accessory(temp);
		
		ModelAndView model = new ModelAndView("redirect:/owner/purchase_record/"+purchase_recordId);
		model.addObject("clist", Cycle_frameManager.allCycle_frame(Integer.parseInt(purchase_recordId)));
		model.addObject("cmlist", Cycle_modelManager.allCycle_model());
		model.addObject("amlist", AccessoryManager.allAccessory());
		model.addObject("alist", Purchase_accessoryManager.allPurchase_accessory(Integer.parseInt(purchase_recordId)));
		model.addObject("pr", Purchase_recordManager.readPurchase_record(Integer.parseInt(purchase_recordId)));
		return model;
	}
	
}