package com.company;

import java.io.SyncFailedException;
import java.util.Scanner;
import java.util.Arrays;

public class Rob {

    Scanner scanner = new Scanner(System.in);
    private int num1;
    private int num2;
    private int rob_num1;
    private int rob_num2;
    String[][] grid;

    public Rob() {

        createGridMap();
        placeTheBot();
        chooseDir(rob_num1, rob_num2);
    }

    private void createGridMap(){


        boolean running = true;
        while (running) {
            try {
                System.out.print("Enter number of rows (between 10 and 20): ");
                num1 = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter number of columns (between 10 and 20): ");
                num2 = Integer.parseInt(scanner.nextLine());

                if (num1 > 9 && num1 < 21 && num2 > 9 && num2 < 21) {
                    grid = create_grid(num1, num2);
                    print_grid(grid);
                    running = false;
                } else {
                    System.out.println("Please enter a number between 10 and 20 between");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    private void placeTheBot(){
        boolean running = true;

        while (running) {
            try {
                System.out.println("\nNow we need to place the robot on the grid");
                System.out.println("Enter a start position place enter two new numbers \nbetween 0-" + (num1 - 1) + " and 0-" + (num2 - 1));
                System.out.println("Enter first number: ");
                rob_num1 = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter second number: ");
                rob_num2 = Integer.parseInt(scanner.nextLine());
                place_robot(grid, rob_num1, rob_num2);
                running = false;
            }
            catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }
    }

    private void chooseDir(int rob_num1, int rob_num2) {
        boolean running = true;

        while (running) {
            try {
                System.out.println("And for the direction enter a letter: \n(N=north E=east S=south W=west)");
                String rob_dir = scanner.nextLine().toUpperCase();
                if (rob_dir.equals("N") | rob_dir.equals("E") | rob_dir.equals("S") | rob_dir.equals("W")) {
                    walkTheBot(rob_dir, rob_num1, rob_num2, num1, num2);
                    running = false;
                } else {
                    System.out.println("Please enter a correct letter");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    private void walkTheBot(String rob_dir, int rob_num1, int rob_num2, int num1, int num2) {
        System.out.println("Enter the path you want the robot to take");
        System.out.println("L to turn Left, R to turn Right and F to move Forward");
        String input = scanner.nextLine().toUpperCase();

        String[] ch = input.split("");

        for (int i = 0; i < input.length(); i++) {
            if (ch[i].equals("L")) {
                switch (rob_dir) {
                    case "N":
                        rob_dir = "W";
                        break;
                    case "E":
                        rob_dir = "N";
                        break;
                    case "S":
                        rob_dir = "E";
                        break;
                    case "W":
                        rob_dir = "S";
                        break;
                }
            }
            if (ch[i].equals("R")) {
                switch (rob_dir) {
                    case "N":
                        rob_dir = "E";
                        break;
                    case "E":
                        rob_dir = "S";
                        break;
                    case "S":
                        rob_dir = "W";
                        break;
                    case "W":
                        rob_dir = "N";
                        break;
                }
            }
            if (ch[i].equals("F")) {
                switch (rob_dir) {
                    case "N":
                        rob_num1 = rob_num1 - 1;
                        if (rob_num1 < 0 || rob_num1 > num1){
                            rob_num1 = rob_num1 + 1;
                        }
                        break;
                    case "E":
                        rob_num2 = rob_num2 + 1;
                        if (rob_num2 < 0 || rob_num2 > num2){
                            rob_num2 = rob_num2 - 1;
                        }
                        break;
                    case "S":
                        rob_num1 = rob_num1 + 1;
                        if (rob_num1 < 0 || rob_num1 > num1){
                            rob_num1 = rob_num1 - 1;
                        }
                        break;
                    case "W":
                        rob_num2 = rob_num2 - 1;
                        if (rob_num2 < 0 || rob_num2 > num2){
                            rob_num2 = rob_num2 + 1;
                        }
                        break;
                }
            }
        }
        place_robot(grid, rob_num1, rob_num2);
        System.out.println("Report: " + (rob_num1)+ " " + (rob_num2) + " " + (rob_dir));
    }


    private String[][] create_grid(int num1, int num2) {
        String[][] grid = new String[num1][num2];

        for (String[] row : grid) {
            Arrays.fill(row, "[ ]");
        }

        return grid;
    }

    private void print_grid(String[][] grid) {
        for (String[] row : grid) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private void place_robot(String[][] grid, int rob_num1, int rob_num2) {
/*        grid[rob_num1][rob_num2] = "[O]";
         // Just to see if the bot is placed correct
        for (String[] row : grid) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }*/
    }
}
