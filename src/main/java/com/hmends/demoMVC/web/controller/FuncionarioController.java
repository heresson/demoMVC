package com.hmends.demoMVC.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hmends.demoMVC.domain.Cargo;
import com.hmends.demoMVC.domain.Funcionario;
import com.hmends.demoMVC.domain.UF;
import com.hmends.demoMVC.service.CargoService;
import com.hmends.demoMVC.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", service.buscarTodos());
		return "/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		service.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionario inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", service.buscarPorId(id));
		return "/funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Funcionario funcionario, RedirectAttributes attr) {
		service.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionario editado com sucesso.");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
			service.excluir(id);
			model.addAttribute("success", "Funcionario excluido com sucesso.");
				
		return listar(model);
	}
	

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("funcionarios", service.buscarPorNome(nome));
		return "/funcionario/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {		
		model.addAttribute("funcionarios", service.buscarPorCargo(id));
		return "/funcionario/lista";
	}
	
	 @GetMapping("/buscar/data")
	    public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
	                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
	                              ModelMap model) {

	        model.addAttribute("funcionarios", service.buscarPorData(entrada, saida));
	        return "/funcionario/lista";
	    }
	
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
