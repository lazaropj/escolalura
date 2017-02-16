package br.com.alura.escolalura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.alura.escolalura.model.Aluno;
import br.com.alura.escolalura.model.Habilidade;
import br.com.alura.escolalura.repository.AlunoRepository;

@Controller
public class HabilidadeController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	@GetMapping("/habilidade/salvar/{id}")
	public String salvar(@PathVariable("id") String id, Model model){
		Aluno aluno = alunoRepository.findOne(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("habilidade", new Habilidade());
		return "habilidade/cadastrar";
	}
	
	@PostMapping("/habilidade/salvar/{id}")
	public String salvar(@PathVariable("id") String id, @ModelAttribute Habilidade habilidade){
		Aluno aluno = alunoRepository.findOne(id);
		alunoRepository.save(aluno.adicionarHabilidade(aluno, habilidade));
		return "redirect:/aluno/listar";
	}
	
}
