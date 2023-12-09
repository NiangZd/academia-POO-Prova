package visao;

import aplicacao.*;
import persistencia.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {

		Aluno a1 = new Aluno("Jão", 18, 72.5f , "jaozindelas@gmai.com", "jao123");

		AlunoDAO.inserirAluno(a1);

	}
}