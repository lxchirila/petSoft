package com.vetsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vetsoft.entity.Pacient;
import com.vetsoft.service.PacientService;

@Controller
public class PacientController {
	@Autowired
	private PacientService service;

	@RequestMapping("/listaPacienti")
	public String listaPacienti(Model model, @Param("keyword") String keyword) {

		List<Pacient> listaPacienti = service.listAll(keyword);
		model.addAttribute("listaPacienti", listaPacienti);
		model.addAttribute("keyword", keyword);
		return "pacient/lista";
	}

	@RequestMapping("/newPacient")
	public String showNewPacientPage(Model model) {
		Pacient pacient = new Pacient();
		model.addAttribute("pacient", pacient);

		return "pacient/new_pacient";
	}

	@RequestMapping(value = "/savePacient", method = RequestMethod.POST)
	public String savePacient(@ModelAttribute("pacient") Pacient pacient) {
		service.save(pacient);

		return "redirect:/listaPacienti";
	}

	@RequestMapping("/editPacient/{id}")
	public ModelAndView showEditPacientPage(@PathVariable(name = "id") long id) {
		ModelAndView model = new ModelAndView("pacient/edit_pacient");
		Pacient pacient = service.get(id);
		model.addObject("pacient", pacient);

		return model;
	}

	@RequestMapping("/deletePacient/{id}")
	public String deletePacient(@PathVariable(name = "id") long id) {
		service.delete(id);
		return "redirect:/listaPacienti";
	}
}
