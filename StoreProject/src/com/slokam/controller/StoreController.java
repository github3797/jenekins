package com.slokam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.slokam.pojo.StorePojo;
import com.slokam.pojo.loginpojo;
import com.slokam.service.StoreService;

@Controller
public class StoreController 
{
	@Autowired
	private StoreService ser;
	public void setSer(StoreService ser) {
		this.ser = ser;
	}
	
	
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ModelAndView loginController(loginpojo login)
	{
		boolean flag=ser.loginservice(login);
		if(flag)
		{
		return new ModelAndView("store.jsp","emp",new StorePojo());
		}
		else
		{
			return new ModelAndView("login.jsp");
		}
	}
	
	@RequestMapping("register")
		public ModelAndView registerController(StorePojo p)
		{
			ser.registerService(p);
			return new ModelAndView("store.jsp","emp",new StorePojo());
		}
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public ModelAndView updateController(StorePojo p)
	{
		ser.updateService(p);
		return new ModelAndView("store.jsp","emp",new StorePojo());
	}
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public ModelAndView deleteController(StorePojo p)
	{
		ser.deleteService(p);
		return new ModelAndView("store.jsp","emp",new StorePojo());

	}

	
	@RequestMapping(value="getall",method = RequestMethod.POST)
	public ModelAndView getAllController(Model model)
	{
		List<StorePojo> users=ser.getAllService();
		
		 model.addAttribute("users", users);
		return new ModelAndView("GetAll.jsp");
	}
	
	@RequestMapping(value="getiddata",method = RequestMethod.GET)
	public ModelAndView registerController1(Integer id)
	{
		StorePojo rpojo=	ser.registerService1(id);
	
		return new ModelAndView("store.jsp","emp", rpojo);
		
	}
}