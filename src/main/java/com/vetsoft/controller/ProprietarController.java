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

import com.vetsoft.entity.Proprietar;
import com.vetsoft.service.ProprietarService;

@Controller
public class ProprietarController {
	@Autowired
	private ProprietarService service;

	@RequestMapping("/listaProprietari")
	public String listaProprietari(Model model, @Param("keyword") String keyword) {

		List<Proprietar> listaProprietari = service.listAll(keyword);
		model.addAttribute("listaProprietari", listaProprietari);
		model.addAttribute("keyword", keyword);
		return "proprietar/lista";
	}

	@RequestMapping("/newProprietar")
	public String showNewProprietariPage(Model model) {
		Proprietar proprietar = new Proprietar();
		model.addAttribute("proprietar", proprietar);

		return "proprietar/new_proprietar";
	}

	@RequestMapping(value = "/saveProprietar", method = RequestMethod.POST)
	public String saveProprietar(@ModelAttribute("proprietar") Proprietar proprietar) {
		service.save(proprietar);

		return "redirect:/listaProprietari";
	}

	@RequestMapping("/editProprietar/{id}")
	public ModelAndView showEditProprietarPage(@PathVariable(name = "id") int id) {
		ModelAndView model = new ModelAndView("proprietar/edit_proprietar");
		Proprietar proprietar = service.get(id);
		model.addObject("proprietar", proprietar);

		return model;

	}

	@RequestMapping("/deleteProprietar/{id}")
	public String deleteProprietar(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/listaProprietari";
	}
}
