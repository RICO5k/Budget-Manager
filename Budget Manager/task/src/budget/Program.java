package budget;

import budget.Commands.*;

import java.util.List;
import java.util.Scanner;

public class Program {

    private Scanner scanner;

    private Menu menu;
    private Budget budget;

    private boolean running;

    public Program(Scanner scanner) {
        this.scanner = scanner;
        this.menu = new Menu();
        this.budget = new Budget();
        this.running = true;

        initializeMenuOptions();
    }

    public void initializeMenuOptions() {
        menu.setCommand(1, new AddIncomeCommand(budget, scanner));
        menu.setCommand(2, new AddPurchaseCommand(budget, scanner));
        menu.setCommand(3, new ShowPurchasesCommand(budget));
        menu.setCommand(4, new BalanceCommand(budget));
        menu.setCommand(0, new ExitCommand(this));
    }

    public void run() {
        while(running) {
            printMenu();

            int command = readCommand();

            menu.runCommand(command);
        }
    }

    public void printMenu() {
        List<String> commandStrings = menu.getCommandStrings();

        System.out.println("Choose your action:");

        for(String command : commandStrings) {
            System.out.println(command);
        }

    }

    public int readCommand() {
        int cmd = Integer.parseInt(scanner.nextLine());

        while(!menu.hasCommand(cmd)) {
            System.out.println("Unknown command, please repeat: ");
            cmd = scanner.nextInt();
        }

        return cmd;
    }

    public void endProgram() {
        running = false;
    }
}
