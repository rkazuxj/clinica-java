import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private List<Medicos> medicos = new ArrayList<>();

    public Menu() {
        Medicos d1 = new Medicos();
        d1.setNome("Thiago Fernandes Gomes"); d1.setEspecialidade("Clínico Geral"); d1.setCrm("37465");
        medicos.add(d1);

        Medicos d2 = new Medicos();
        d2.setNome("Ana Beatriz Souza"); d2.setEspecialidade("Cardiologista"); d2.setCrm("10293");
        medicos.add(d2);

        Medicos d3 = new Medicos();
        d3.setNome("Juliana Pereira Rocha"); d3.setEspecialidade("Pediatra"); d3.setCrm("82739");
        medicos.add(d3);

        Medicos d4 = new Medicos();
        d4.setNome("Carlos Eduardo Mendes"); d4.setEspecialidade("Ortopedista"); d4.setCrm("48291");
        medicos.add(d4);

        Medicos d5 = new Medicos();
        d5.setNome("Fernanda Lima Costa"); d5.setEspecialidade("Dermatologista"); d5.setCrm("75634");
        medicos.add(d5);

        Medicos d6 = new Medicos();
        d6.setNome("Marcos Vinícius Carvalho"); d6.setEspecialidade("Oftalmologista"); d6.setCrm("51928");
        medicos.add(d6);

        Medicos d7 = new Medicos();
        d7.setNome("Camila Barros Rodrigues"); d7.setEspecialidade("Ginecologista"); d7.setCrm("28374");
        medicos.add(d7);

        Medicos d8 = new Medicos();
        d8.setNome("Ricardo Almeida Santos"); d8.setEspecialidade("Neurologista"); d8.setCrm("39482");
        medicos.add(d8);

        Medicos d9 = new Medicos();
        d9.setNome("Patrícia Ribeiro Alves"); d9.setEspecialidade("Psiquiatra"); d9.setCrm("91827");
        medicos.add(d9);

        Medicos d10 = new Medicos();
        d10.setNome("Roberto Cavalcanti Neto"); d10.setEspecialidade("Endocrinologista"); d10.setCrm("45102");
        medicos.add(d10);

        Medicos d11 = new Medicos();
        d11.setNome("Felipe Monteiro Silva"); d11.setEspecialidade("Urologista"); d11.setCrm("64738");
        medicos.add(d11);
    }

    public void MenuMain() { 
        while (true) { 
            System.out.println("\n====================================================");
            System.out.println("        MENU PRINCIPAL - CLINICA KAZUNELLI           ");
            System.out.println("====================================================");
            System.out.println("[1] Cadastrar Médico");
            System.out.println("[2] Agendar Consulta");
            System.out.println("[0] Sair do Sistema");
            System.out.println("=============================================");
            System.out.print(">>> Escolha uma opção: ");
            
            String opcao = sc.next();

            if (opcao.equals("1")) {
                CadastrarMedico();
            } else if (opcao.equals("2")) {
                Agendamento();
            } else if (opcao.equals("0")) {
                System.out.println("\nEncerrando o sistema... Até logo!");
                break; 
            } else {
                System.out.println("\n[ERRO] Opção inválida. Tente novamente.");
            }
        }
    }

    public void Agendamento() {
        
        Medicos m = new Medicos();
        Exame con = new Exame();
        
        while (true) { 
        
        System.out.println("\n=============================================");
        System.out.println("        BEM-VINDO À CLÍNICA KAZUNELLI        ");
        System.out.println("=============================================");

        System.out.print("Digite seu nome para começar: "); 
        String nome = sc.next();

        System.out.print("Digite seu CPF: ");
        String cpf = sc.next();

        if (cpf.length() != 11) { 
            System.out.println("\n[ERRO] CPF INVÁLIDO. Encerrando operação.");
            break;
        }

        System.out.print("Digite a sua idade: ");
        int idade = sc.nextInt();

        if (idade < 18) { 
            System.out.println("\n[AVISO] Apenas titulares maiores de idade podem marcar consultas!");
            break;
        }

        System.out.print("Digite sua Matrícula: ");
        String matricula = sc.next();

        Paciente paciente = new Paciente();
        
        paciente.setNome(nome);
        paciente.setIdade(idade);
        paciente.setMatricula(matricula);
        paciente.setCpf(cpf);

        System.out.println("\n=============================================");
        System.out.println("             CONFIRA SEUS DADOS              ");
        System.out.println("=============================================");
        System.out.println("Nome:      " + paciente.getNome());
        System.out.println("CPF:       " + paciente.getCpf());
        System.out.println("Idade:     " + paciente.getIdade() + " anos");
        System.out.println("Matrícula: " + paciente.getMatricula());
        System.out.println("=============================================");

        System.out.print("\n>>> Digite OK para confirmar: ");

        con.setPaciente(paciente.getNome());
        con.setCPF(paciente.getCpf());
        
        String op = sc.next();

        if (!op.toUpperCase().equals("OK") ) {
            break;
        }

        System.out.println("\n=============================================");
        System.out.println("           LISTA DE ESPECIALIDADES           ");
        System.out.println("=============================================");

        Especialidades espec = new Especialidades();
        System.out.println(espec.getLista());
        System.out.println("=============================================");

        System.out.print("\n>>> Escolha a especialidade para continuar: ");
        String especialidade = sc.next();
        con.setEspecialidade(especialidade);

        if (!espec.getLista().contains(especialidade)) { 
            System.out.println("\n[ERRO] Especialidade inválida.");
            continue;
        } 
 
        System.out.println("\n=============================================");
        System.out.println("  MÉDICOS DISPONÍVEIS (" + especialidade.toUpperCase() + ")");
        System.out.println("=============================================");

        boolean encontrouMedico = false;

        for (Medicos med : getMedicos()) {
            if (med.getEspecialidade().toUpperCase().equals(especialidade.toUpperCase())) {
                System.out.println("- Dr(a). " + med.getNome());
                encontrouMedico = true;
            } 
        }

        if (!encontrouMedico) { 
            System.out.println("\n[AVISO] Não há médicos cadastrados para essa modalidade.");
            continue;
        }

        System.out.println("=============================================");

        System.out.print("\n>>> Digite o nome do médico que deseja se consultar: ");
        sc.nextLine();
        String nomeMedico = sc.nextLine();

        boolean encontrouMedicoEscolhido = false;

        for (Medicos med : getMedicos()) {
            if (med.getNome().toUpperCase().equals(nomeMedico.toUpperCase())){
                con.setMedico(med.getNome());
                con.setCRM(med.getCrm());
                encontrouMedicoEscolhido = true;
                break;
            }     
        }

        if (!encontrouMedicoEscolhido) {
            System.out.println("\n[ERRO] Médico não encontrado. Tente novamente.");
            continue; 
        }

        System.out.println("\n=============================================");
        System.out.println("        CONSULTA AGENDADA COM SUCESSO!       ");
        System.out.println("=============================================");
        System.out.println("Paciente:      " + con.getPaciente());
        System.out.println("CPF:           " + con.getCPF());
        System.out.println("Especialidade: " + con.getEspecialidade());
        System.out.println("Médico:        " + con.getMedico());
        System.out.println("CRM:           " + con.getCRM());
        System.out.println("=============================================\n");

        System.out.print(">>> Pressione [ENTER] para voltar ao Menu Principal...");
        sc.nextLine();
        
        break;
        }
    }
    
    public void CadastrarMedico(){
        while (true) {
    
            System.out.println("\n=============================================");
            System.out.println("              CADASTRAR MÉDICO               ");
            System.out.println("=============================================");
            System.out.print("Digite o nome do médico: ");
            String nome = sc.next();
    
            System.out.print("Digite a especialidade do médico: ");
            String especialidade = sc.next();
    
            System.out.print("Digite o CRM do médico: ");
            String crm = sc.next();
    
            Medicos medico = new Medicos();
            
            medico.setNome(nome);
            medico.setEspecialidade(especialidade);
            medico.setCrm(crm);
            
            System.out.println("\n=============================================");
            System.out.println("             CONFIRA SEUS DADOS              ");
            System.out.println("=============================================");
            System.out.println("Nome:          " + medico.getNome());
            System.out.println("Especialidade: " + medico.getEspecialidade());
            System.out.println("CRM:           " + medico.getCrm());
            System.out.println("=============================================");

            medicos.add(medico);
            
            System.out.print("\n>>> Digite OK para continuar cadastrando (ou outra tecla para encerrar): ");
            String decisao = sc.next();

            if (decisao.toUpperCase().equals("OK")) { 
                continue;
            } else {
                System.out.println("\n=============================================");
                System.out.println("             MÉDICOS CADASTRADOS             ");
                System.out.println("=============================================");
                for (Medicos m : getMedicos()) {
                    System.out.println("Nome:          " + m.getNome());
                    System.out.println("Especialidade: " + m.getEspecialidade());
                    System.out.println("CRM:           " + m.getCrm());
                    System.out.println("---------------------------------------------");
                }
        System.out.println("=============================================\n");

        System.out.print(">>> Pressione [ENTER] para voltar ao Menu Principal...");
        sc.nextLine();
        
        break;
            }
        }
    }

    public List<Medicos> getMedicos() {
        return medicos;
    }
}