import java.util.Scanner;

public class Ninja {
    String habilidadeEspecial;
    char nivelDeDificuldade;
    protected String name, mission, status;
    protected int idade;
    static int contadors = 0;
    static int contadoru = 0;

    public Ninja(String name, int idade, String mission, char nivelDeDificuldade, String status, String clan) {
        this.name = name;
        this.idade = idade;
        this.mission = mission;
        this.nivelDeDificuldade = nivelDeDificuldade;
        this.status = status;
        this.habilidadeEspecial = "Shuriken";
    }

    public static void cadastrarNovoNinja() {
        String clan = "Uchiha";
        Scanner scannerNinja = new Scanner(System.in);

        System.out.println("Qual nome do seu ninja?");
        String name = scannerNinja.nextLine();

        System.out.println("Qual a idade do seu ninja?");
        int idade = scannerNinja.nextInt();
        scannerNinja.nextLine();

        System.out.println("Qual missão do seu ninja?");
        String mission = scannerNinja.nextLine();

        System.out.println("Qual a classificação do seu ninja? (ex: A, B, C)");
        char nivelDeDificuldade = scannerNinja.nextLine().charAt(0);

        System.out.println("Qual status missão do seu ninja?");
        String status = scannerNinja.nextLine();

        System.out.println("Qual clan do seu ninja? (1 - Uchiha, 2 - Outro)");
        int chose = scannerNinja.nextInt();
        scannerNinja.nextLine();

        switch (chose) {
            case 1:
                clan = "Uchiha";
                Ninja acUchiha = new Uchiha(name, idade, mission, nivelDeDificuldade, status, clan);
                Main.grupoDeNinjas[1][contadoru] = (Uchiha) acUchiha;
                contadoru++;
                break;
            case 2:
                clan = "Outro";
                Ninja acNinja = new Ninja(name, idade, mission, nivelDeDificuldade, status, clan);
                Main.grupoDeNinjas[0][contadors] = acNinja;
                contadors++;
                break;
            default:
                System.out.println("Clan inválido, ninja não cadastrado.");
                return;
        }

        System.out.println("Ninja cadastrado com sucesso!");
    }

    public String getName() {
        return this.name;
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + name);
        System.out.println("Idade: " + idade);
        System.out.println("Missão: " + mission);
        System.out.println("Nível de Dificuldade: " + nivelDeDificuldade);
        System.out.println("Status da Missão: " + status);
    }

    public static void mostrarTodosNinjas() {
        for (int i = 0; i < Main.grupoDeNinjas.length; i++) {
            for (int j = 0; j < Main.grupoDeNinjas[i].length; j++) {
                Ninja ninja = Main.grupoDeNinjas[i][j];
                if (ninja != null) {
                    ninja.mostrarInformacoes();
                    ninja.mostrarHabilidadesEspeciais();
                    System.out.println("-----------------");
                }
            }
        }
    }

    public void setHabilidadeEspecial(String habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public void mostrarHabilidadesEspeciais() {
        System.out.println("Habilidade especial: " + habilidadeEspecial);
    }

    public static void mudarHabilidade() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do Ninja que deseja trocar a habilidade especial:");
        String nome = scanner.nextLine();

        boolean encontrado = false;

        for (Ninja ninja : Main.Ninjas) {
            if (ninja != null && ninja.getName().equals(nome)) {
                System.out.println("Digite a nova habilidade especial:");
                String novaHabilidade = scanner.nextLine();
                ninja.setHabilidadeEspecial(novaHabilidade);
                System.out.println("Habilidade atualizada com sucesso!");
                ninja.mostrarHabilidadesEspeciais();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Ninja com esse nome não foi encontrado.");
        }
    }
}
