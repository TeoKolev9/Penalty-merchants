import java.util.Scanner;

public class Igra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Igrach i1 = new Igrach("Darwin", 23, 82);
        Igrach i2 = new Igrach("Maguire", 30, 50);
        Igrach i3 = new Igrach("Kazakov", 29, 60);
        Igrach i4 = new Igrach("Pessi", 35, 87);
        Igrach i5 = new Igrach("Ronaldo", 38, 99);
        Igrach[] players = {i1, i2, i3, i4, i5};
        String[] goalkeepers = {"Left", "Center", "Right"};
        int playerScore = 0;
        int goalkeeperScore = 0;
        int[][] field = {
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 9, 4},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 9, 3},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 9, 3},
            {5, 8, 1, 8, 8, 8, 8, 8, 8, 5, 7, 9, 3},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 9, 3},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 9, 3},
            {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 9, 6}
        };
        System.out.println("Welcome to Penalty Merchants!");
        while (true) {
            System.out.println("\nScore: Player " + playerScore + " - " + goalkeeperScore + " Goalkeeper");
            System.out.println("Select a player:");
            for (int i = 0; i < players.length; i++) {
                System.out.println((i + 1) + ". " + players[i].getName() +"// - " + players[i].getGodini()+ " age - "+ players[i].getRating() + " rating");
            }
            System.out.print("Enter the player number: ");
            int playerChoice = scanner.nextInt();
            scanner.nextLine();
            Igrach selectedPlayer = players[playerChoice - 1];
            System.out.print("Enter your shot direction (left/right): ");
            String playerShotDirection = scanner.nextLine();

            int goalkeeperIndex = (int) (Math.random() * goalkeepers.length);
            String goalkeeperMovement = goalkeepers[goalkeeperIndex];

            
            if (playerShotDirection.equalsIgnoreCase("left")) {
              
                int initialBallRow = -1;
                int initialBallCol = -1;
                for (int row = 0; row < field.length; row++) {
                    for (int col = 0; col < field[row].length; col++) {
                        if (field[row][col] == 1) {
                            initialBallRow = row;
                            initialBallCol = col;
                            break;
                        }
                    }
                    if (initialBallRow != -1) {
                        break;
                    }
                }

                if (initialBallRow != -1) {
                    field[initialBallRow][initialBallCol] = 8;

                    int newRow = (int) (Math.random() * 3);
                    int newCol = 11;
                    while (field[newRow][newCol] != 7) {
                        newRow = (int) (Math.random() * 3);
                        newCol = (int) (Math.random() * 12);
                    }
                    field[newRow][newCol] = 1; 
                }
            }

            if (playerShotDirection.equalsIgnoreCase("right")) {
       
                int initialBallRow = -1;
                int initialBallCol = -1;
                for (int row = 0; row < field.length; row++) {
                    for (int col = 0; col < field[row].length; col++) {
                        if (field[row][col] == 1) {
                            initialBallRow = row;
                            initialBallCol = col;
                            break;
                        }
                    }
                    if (initialBallRow != -1) {
                        break;
                    }
                }

                if (initialBallRow != -1) {
                    field[initialBallRow][initialBallCol] = 8; 

                    
                    int newRow = (int) (Math.random() * 3) + 4;
                    int newCol = 11;
                    while (field[newRow][newCol] != 7) {
                        newRow = (int) (Math.random() * 3) + 4;
                        newCol = (int) (Math.random() * 12);
                    }
                    field[newRow][newCol] = 1; 
                }
            }

            System.out.println("Player " + selectedPlayer.getName() + " shoots " + playerShotDirection + ", Goalkeeper moves " + goalkeeperMovement);
            Field(field);

           
            if (!playerShotDirection.equalsIgnoreCase(goalkeeperMovement)) {
                System.out.println("Goal! Player scores!");
                playerScore++;
            } else {
                System.out.println("Miss! Goalkeeper saves!");
                goalkeeperScore++;
            }

            if (playerScore == 5 || goalkeeperScore == 5) {
                break;
            }
            System.out.print("Do you want to continue? (yes/no): ");
            String continuePlaying = scanner.nextLine();

            if (!continuePlaying.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("\nFinal Score: Player " + playerScore + " - " + goalkeeperScore + " Goalkeeper");
        System.out.println("Thanks for playing! Goodbye!");
    }
    public static void Field(int[][] field) {
        for (int[] row : field) {
            for (int cell : row) {
                if (cell == 1) {
                    System.out.print("⚽");
                } else if (cell == 3) {
                    System.out.print("|");
                } else if (cell == 4) {
                    System.out.print("┐");
                } else if (cell == 5) {
                    System.out.print("☺");
                } else if (cell == 6) {
                    System.out.print("┘");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}