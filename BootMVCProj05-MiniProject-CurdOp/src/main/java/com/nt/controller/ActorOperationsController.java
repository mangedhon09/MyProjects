package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

@Controller
public class ActorOperationsController {
   @Autowired
	private IActorMgmtService actorService;

   @GetMapping("/")
   public String showHomePage() {
	   return "welcome";
   }
   @GetMapping("/report")
   public String showReport(Map<String,Object>map) {
	   //use service
	   List<Actor>list=actorService.showAllActors();
	   //keep the results in model attributes
	   map.put("listActors", list);
	   //return LVN
	   return "show_report";
   }
   @GetMapping("/register")
   public String showFormPageFormRegisterActor(@ModelAttribute("actor") Actor actor) {
	     //return LVN
	   return "actor_register_form";
   }
	/* @PostMapping("/register")
	 public String registerActor(@ModelAttribute("actor") Actor actor, Map<String ,Object>map) {
	    //use service
	   String msg=actorService.resgisterActor(actor);
	List<Actor>list=actorService.showAllActors();
	   //keep the result is
	 map.put("resultMsg", msg);
	 map.put("listActors", list);
	 //return LVN
	 return "show_report";
	 }*/
   @PostMapping("/register")
   public String registerActor(@ModelAttribute("actor") Actor actor, RedirectAttributes attrs) {
	    //use service
	   String msg=actorService.registerActor(actor);
	List<Actor>list=actorService.showAllActors();
	   //keep the result is
     attrs.addFlashAttribute("resultMsg", msg);
     attrs.addFlashAttribute("listActors", list);
     //return LVN
     return "redirect:report";
   }
   @GetMapping("/edit")
   public String editActorFormPage(@ModelAttribute("actor") Actor actor ,@RequestParam("no") int id) {
	   // use service
	   Actor actor1=actorService.fetchActorByID(id);
	//copy data to model class object
	   BeanUtils.copyProperties(actor1, actor);
	   return "actor_edit_form";
	   
   }
   
   @PostMapping("/edit")
   public String editActor(@ModelAttribute ("actor") Actor actor, 
		                   RedirectAttributes attrs) {
	    //use service
	   String msg=actorService.editActor(actor);
	   //keep the results in flash attributes
	   attrs.addFlashAttribute("resultMsg",msg);
	   //redirect the request
	   return "redirect:report";
   }
   @GetMapping("/delete")
   public String removeActorById(@RequestParam ("no") int id,
		                         Map<String,Object>map) {
	   //use service
	   String msg=actorService.deleteActorById(id);
  //keep the results in flash attributes
	   map.put("resultMsg",msg);
	   //forward the request
	    return"forward:report";
   }
   
}

