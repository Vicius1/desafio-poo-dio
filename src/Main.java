import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("Descrição mentoria Java");
        mentoria1.setData(LocalDate.now());

        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria1);


        System.out.println("Bem-vindo ao sistema de " + bootcamp.getNome());
        System.out.println("Qual seu nome?");
        String nomeDev = scanner.nextLine();
        Dev dev1 = new Dev();
        dev1.setNome(nomeDev);

        System.out.println("Olá, " +  dev1.getNome() + "! Escolha uma opção:");
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Inscrever-se no Bootcamp");
            System.out.println("2. Progredir no conteúdo");
            System.out.println("3. Mostrar conteúdos inscritos");
            System.out.println("4. Mostrar conteúdos concluídos");
            System.out.println("5. Calcular XP total");
            System.out.println("6. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    dev1.inscreverBootcamp(bootcamp);
                    System.out.println("Inscrição realizada com sucesso!");
                    break;
                case 2:
                    try {
                        dev1.progredir();
                        System.out.println("Progresso realizado com sucesso!");
                    } catch (IllegalStateException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Conteúdos Inscritos: " + dev1.getConteudosInscritos());
                    break;
                case 4:
                    System.out.println("Conteúdos Concluídos: " + dev1.getConteudosConcluidos());
                    break;
                case 5:
                    System.out.println("XP Total: " + dev1.calcularTotalXp());
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();

    }

}
