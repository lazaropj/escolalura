package br.com.alura.escolalura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.alura.escolalura.model.Aluno;
import br.com.alura.escolalura.model.Nota;
import br.com.alura.escolalura.repository.AlunoRepository;

@Controller
public class NotaController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	@GetMapping("/nota/salvar/{id}")
	public String salvar(@PathVariable("id") String id, Model model){
		Aluno aluno = alunoRepository.findOne(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("nota", new Nota());
		return "nota/cadastrar";
	}
	
	@PostMapping("/nota/salvar/{id}")
	public String salvar(@PathVariable("id") String id, @ModelAttribute Nota nota){
		Aluno aluno = alunoRepository.findOne(id);
		alunoRepository.save(aluno.adicionarNota(aluno, nota));
		return "redirect:/aluno/listar";
	}
	
}
