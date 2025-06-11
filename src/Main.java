import java.util.Scanner;

public class Main {

    static Ninja[] Ninjas = new Ninja[100];
    static Uchiha[] Uchihas = new Uchiha[100];
    static Ninja[][] grupoDeNinjas = {Ninjas, Uchihas};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int chose = 0;
        while(chose != 4) {
            System.out.println("==============================\n" +
                    "        MENU DE NINJAS        \n" +
                    "==============================\n" +
                    "1. \uD83D\uDCDD Cadastrar novo ninja\n" +
                    "2. \uD83D\uDEE0\uFE0F  Atualizar habilidades especiais\n" +
                    "3. \uD83E\uDDD0 Exibir informações de todos os ninjas\n" +
                    "4. ❌ Sair\n" +
                    "------------------------------\n" +
                    "Escolha uma opção: ");

            chose = Main.scanner.nextInt();
            Main.scanner.nextLine(); // limpar buffer

            switch (chose) {
                case 1:
                    Ninja.cadastrarNovoNinja();
                    break;
                case 2:
                    System.out.println("Deseja atualizar habilidade de qual tipo de ninja?");
                    System.out.println("1 - Uchiha");
                    System.out.println("2 - Ninja comum");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    if (tipo == 1) {
                        Uchiha.mudarHabilidade();
                    } else if (tipo == 2) {
                        Ninja.mudarHabilidade();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 3:
                    Ninja.mostrarTodosNinjas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
