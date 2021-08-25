package com.homework.one;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            int rowGlobal = 0;
            int columnGlobal = 0;
            int choiceGlobal;
            String[] random3Char = {"A", "B", "C", "D", "E", "F",
                                     "G", "H", "I", "J", "K", "L",
                                     "M", "N", "O", "P", "Q", "R",
                                     "S", "T", "U", "V", "W", "X",
                                     "Y", "Z", "!", "@", "#", "$",
                                     "%", "^", "&", "*", "(", ")",
                                     "+", "="};
            String[][] matrix = new String[50][50];
            Scanner scanner = new Scanner(System.in);

            do {
                displayChoice();
                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                choiceGlobal = choice;

                switch (choice) {
                    case 1:

                        Random random = new Random();
                        //Generate matrix size, add value each cell
                        System.out.print("Enter matrix size: ");
                        int row = scanner.nextInt();
                        int column = scanner.nextInt();
                        rowGlobal = row; columnGlobal = column;
                        scanner.nextLine();
                        for (int i = 0 ; i < row; i++){
                            for (int j = 0; j < column; j++){
                                int randomX = 0;
                                StringBuilder app = new StringBuilder();

                                while (randomX < 3){
                                    int g = random.nextInt(random3Char.length);
                                    app.append(random3Char[g]);
                                    randomX++;
                                }
                                String store = app.toString();
                                matrix[i][j] = store;
                            }
                        }

                        System.out.println("\n");
                        for (int i = 0 ; i < row; i++){
                            for (int j = 0; j < column; j++){
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println("\n");
                        }
                        break;

                    case 2:
                        //search character occurrences
                        System.out.print("Enter character to search: ");
                        String characterSearch = scanner.nextLine();

                        for (int i = 0 ; i < rowGlobal; i++){
                            for (int j = 0; j < columnGlobal; j++){
                                int ctr = 0;
                                if (matrix[i][j].contains(characterSearch)){
                                    System.out.println("\n[" + i + "," + j +
                                            "] - " + (++ctr) + " Occurrence/s");
                                }
                            }
                        }
                    break;

                    case 3:
                        //edit cell in matrix
                        System.out.print("Enter matrix index:");
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter new value: ");
                        String newValue = scanner.nextLine();
                        matrix[a][b] = newValue;

                        System.out.println("Matrix [" + a + "," + b + "]" + " is changed with a new value " +
                                newValue);

                        for (int i = 0 ; i < rowGlobal; i++){
                            for (int j = 0; j < columnGlobal; j++){
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println("\n");
                        }
                        break;

                    case 4:
                        //Print table
                        System.out.println("Printing Matrix....... \n");

                        for (int i = 0 ; i < rowGlobal; i++){
                            for (int j = 0; j < columnGlobal; j++){
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println("\n");
                        }
                        break;

                    case 5:
                        //Reset matrix
                        System.out.println("Resetting Matrix Table....... Done resetting");
                        for (int i = 0 ; i < rowGlobal; i++){
                            for (int j = 0; j < columnGlobal; j++){
                                matrix[i][j] = "0";
                            }
                        }

                        for (int i = 0 ; i < rowGlobal; i++){
                            for (int j = 0; j < columnGlobal; j++){
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println("\n");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting program.......... terminated successfully");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Choice " + choice + " is invalid :(");
                        break;
                }
            } while (choiceGlobal != 6);
    }

    public static void displayChoice(){
        System.out.println("SELECT OPTION:");
        System.out.println("[1] - GENERATE N X N MATRIX");
        System.out.println("[2] - SEARCH FOR CHARACTER OCCURRENCES");
        System.out.println("[3] - EDIT CELL IN MATRIX");
        System.out.println("[4] - PRINT TABLE");
        System.out.println("[5] - RESET MATRIX");
        System.out.println("[6] - QUIT");
    }
}
