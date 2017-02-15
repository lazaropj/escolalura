package br.com.alura.escolalura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.alura.escolalura.model.Aluno;
import br.com.alura.escolalura.repository.AlunoRepository;

@Controller("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	@GetMapping("/aluno/listar")
	public String listar(Model model){
		
		List<Aluno> alunos = alunoRepository.findAll();
		
		model.addAttribute("alunos", alunos);
		
		return "aluno/listar";
	}
	
	@GetMapping("/aluno/salvar")
	public String salvar(Model model){
		model.addAttribute("aluno", new Aluno());
		return "aluno/cadastrar";
	}
	
	@PostMapping("/aluno/salvar")
	public String salvar(@ModelAttribute Aluno aluno){
		alunoRepository.save(aluno);

		return "redirect:/aluno/listar";
	}
	
	@GetMapping("/aluno/visualizar/{id}")
	public String visualizar(@PathVariable("id") String id, Model model){
		
		Aluno aluno = alunoRepository.findOne(id);
		
		model.addAttribute("aluno", aluno);
		
		return "aluno/visualizar";
		
	}
	
	
}
