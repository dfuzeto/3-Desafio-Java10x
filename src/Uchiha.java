import java.util.Scanner;

public class Uchiha extends Ninja {
    private String habilidadeEspecial;

    public Uchiha(String name, int idade, String mission, char nivelDeDificuldade, String status, String clan) {
        super(name, idade, mission, nivelDeDificuldade, status, clan);
        this.habilidadeEspecial = "Sharingan";
    }

    @Override
    public void mostrarHabilidadesEspeciais() {
        System.out.println("Habilidade especial: " + habilidadeEspecial);
    }

    public void setHabilidadeEspecial(String habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
        System.out.println("Habilidade Especial: " + habilidadeEspecial);
    }

    public static void mudarHabilidade() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do Uchiha que deseja trocar a habilidade especial:");
        String nome = scanner.nextLine();

        boolean encontrado = false;

        for (Uchiha uchiha : Main.Uchihas) {
            if (uchiha != null && uchiha.getName().equals(nome)) {
                System.out.println("Digite a nova habilidade especial:");
                String novaHabilidade = scanner.nextLine();
                uchiha.setHabilidadeEspecial(novaHabilidade);
                System.out.println("Habilidade atualizada com sucesso!");
                uchiha.mostrarHabilidadesEspeciais();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Ninja Uchiha com esse nome não foi encontrado.");
        }
    }
}
