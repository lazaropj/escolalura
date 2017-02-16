package br.com.alura.escolalura.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "alunos")
public class Aluno {
	
	@Id
	private String id;
	
	private String nome;
	
	private Date dataNascimento;
	
	private Curso curso;
	
	private List<Nota> notas;
	
	private List<Habilidade> habilidades;
	
	public Aluno adicionarHabilidade(Aluno aluno, Habilidade habilidade){
		List<Habilidade> habilidades = aluno.getHabilidades();
		habilidades.add(habilidade);
		aluno.setHabilidades(habilidades);
		return aluno;
		
	}
	
	public Aluno adicionarNota(Aluno aluno, Nota nota){
		List<Nota> notas = aluno.getNotas();
		notas.add(nota);
		aluno.setNotas(notas);
		return aluno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Nota> getNotas() {
		if (notas == null) {
			notas = new ArrayList<>();
		}
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public List<Habilidade> getHabilidades() {
		if (habilidades == null) {
			habilidades = new ArrayList<>();
		}
		return habilidades;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	
	

}
