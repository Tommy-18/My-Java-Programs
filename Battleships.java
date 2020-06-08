import java.util.*;
public class Battleships {
    public static void main(String[] args) {
        /*
        This method is the main method. This is where I will call the other methods and create the enemy and user's
        Map.
         */
        String[][] map = new String[12][12];
        createMap(map);
        System.out.println("The see is currently empty!");
        displayMap(map);
        System.out.println("It is time to deploy the ships!");
        deployShips(map);
        String[][] Enmap = new String[12][12];
        createMap(Enmap);
        EnemyDeploy(map, Enmap);
        StartGame(map, Enmap);
    }

    public static void createMap(String[][] map) {
        /*
        This method creates the board design layout (map) by using nested loops and changing certain elements in the 2D
        array that was given by the method call. I used the Zeroth row (array) and Zeroth column to show the grid
        structure. I also used the 11th row (array) and 11th column of elements to show the boundary of the grid.
        This results in the valid spaces for the ships to be in between [1][1] - [10,10].
         */
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                map[row][col] = " ";
                if (row == 0 && col == 0) {
                    map[row][col] = "   |";
                }
                if (row == 0) {
                    if (col > 0 && col < 11) {
                        map[row][col] = (col - 1) + "";
                    } else if (col == 11) {
                        map[row][col] = "|";
                    }
                } else if ((row >= 1 && row < 11) && col == 0) {
                    map[row][col] += (row - 1) + " |";
                } else if (row == 11) {
                    if (col > 0 && col < 11) {
                        map[row][col] = (col - 1) + "";
                    } else {
                        map[row][col] = "   |";
                    }
                    if (col == 11) {
                        map[row][col] = "|";
                    }
                }

                if (row > 0 & row < 11 && (col == 11)) {
                    map[row][col] = "| " + (row - 1);
                }

            }
        }
    }

    public static void displayMap(String[][] map) {
        /*
        This allows the user to see the map by printing out each element in a row (array)
        and going onto the next line once it finishes that row.
         */
        for (String[] strings : map) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.print("\n");
        }
    }

    public static void deployShips(String[][] map) {
        /*
        This method takes the given map and allows the user to input co-ordinates for where they would like to place
        their ship. This is done by using the scanner utility and for loops and if statements. This map displays to
        help prevent the user accidentally inputting the same location for all of their 6 ships. Just in case they still
        try to place their ship on the same location,the method invalidInput() will be called and a message stating that
        the location that they have put down is not a valid location and will cause the user to input a new value for Y.
         */
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter the x coordinate for your ship: ");
            int x = input.nextInt() + 1;
            if (x > 10 || x < 0) {
                x = invalidInput();

            }
            System.out.print("Enter the y coordinate for your ship: ");
            int y = input.nextInt() + 1;
            if (y > 10 || y < 0 || map[y][x].equals("@")) {
                y = invalidInput();
            }
            map[y][x] = "@";
            displayMap(map);
        }
        displayMap(map);
    }

    public static int invalidInput() {
        /*
        This method is made to catch any invalid input (integers that are under 0 or above 10) and to allow the user to
        type in a new value and return the new value to wherever this method was called from.
         */
        Scanner input = new Scanner(System.in);
        System.out.print("That is not a valid location. Please try and input a valid input: ");
        int val = input.nextInt() + 1;
        while (0 < val && val < 10) {
            System.out.print("That is not a valid location. Please try and input a valid input: ");
            val = input.nextInt();
        }
        return val;
    }


    public static void EnemyDeploy(String[][] map, String[][] Enmap) {
        /*
        This generates random coordinates for the computer to place their ships. It calls the redo method for any ships
        that were about to place in the same location of a pre-existing ship. Once the new ship has had a location
        generated that doesn't have a value their on either map, a ship will be assigned that set of coordinates.
        To make things easier for me to remember, I have made the enemy ships $ and the user's ships @.
         */
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int x = rand.nextInt(10) + 1;
            int y = rand.nextInt(10) + 1;
            if (map[x][y].equals("@") || Enmap[x][y].equals("$")) {
                x = redo(map, y, Enmap);
            }
            Enmap[x][y] = "$";
        }
    }

    public static int redo(String[][] map, int y, String[][] Enmap) {
        /*
        This is similar to the invalidInput method however this generates a new random number for the location and
        returns the new value.
         */
        Random rand = new Random();
        int x = rand.nextInt(10) + 1;
        if (map[x][y].equals("@") || Enmap[x][y].equals("$")) {
            x = redo(map, y, Enmap);
        }
        return x;

    }

    public static boolean fire(String[][] map, String[][] enmap) {
        /*
        This method uses the scanner to allow the user to input valid coordinates for the "attack". However the "attack"
        is just a search method called CheckHit which uses the coordinates and the maps to see whether the coordinates
        overlap the strings "$" or "@".
         */
        Scanner input = new Scanner(System.in);
        System.out.print("What X coordinate would you like to shoot at? ");
        int x = input.nextInt() + 1;
        if (x > 10 || x < 0) {
            x = invalidInput();
        }
        System.out.print("What Y coordinate would you like to shoot at? ");
        int y = input.nextInt() + 1;
        if (y > 10 || y < 0) {
            y = invalidInput();
        }
        System.out.print("Player: ");
        return CheckHit(enmap, x, y, map);


    }

    public static boolean CheckHit(String[][] map1, int x, int y, String[][] map2) {
        /*
        This is the search/ comparison method that looks at the given coordinates in map1 and checks whether there is a
        ship there or not. If there is no ship there, it place a X at that coordinate on the firer's map and state that
        they had missed, If there is a hit, the ship at that given location on the firer's map will turn to an "O" and
        the ship that was shot on the victim's map will change to a "K" to indicate that that ship was killed.
        This method also return a boolean value to indicate whether the ship was hit or not.
         */
        boolean hit = false;
        if (map1[y][x].equals("@") || map1[y][x].equals("$")) {
            map2[y][x] = "O";
            map1[y][x] = "K";
            System.out.println("Hit! ");
            hit = true;
        } else {
            map2[y][x] = "X";
            System.out.println("Miss");
        }
        return hit;
    }


    public static boolean Enfire(String[][] map, String[][] enmap) {
        /*
        This generates random coordinates to search in the user's map for their ship. However in the rare case where
        the generated coordinates have already been fired at, the method will call itself (it acts like a
        recursive method). Once a valid set of coordinates were generated, it will use the CheckHit method to get a
        boolean value to indicate whether it has hit a ship or not.
        */
        Random rand = new Random();
        int x = rand.nextInt(10) + 1;
        int y = rand.nextInt(10) + 1;
        if (enmap[x][y].equals("X")) {
            Enfire(enmap, map);
        }
        System.out.println("Computer's Turn.");
        System.out.print("Computer: ");
        return CheckHit(map, x, y, enmap);
    }

    public static void StartGame(String[][] map, String[][] Enmap) {
        /*
        This method is where the game begins the two integer variables (EnshipLeft and UserShipsLeft) show how many
        ships are remaining in play on their respected maps (EnshipLeft =  Enemy Map (Enmap)), UserShipsLeft = map
        (User's Map)). A while loop is used to repeatedly call the methods fire (User fires) and Enfire (Computer fires)
        and check the if statements to see whether they are true or not. If fire or Enfire = true, the number of ships
        the victim has decrease by one. This loop carries on until either side has zero ships left. Once this happens,
        the loop breaks and both maps are outputted along with how many ships were remaining on either side. Once this
        happens, the code ends.
         */
        int EnshipLeft = 6;
        int UserShipsLeft = 6;
        while (true) {
            boolean hit = fire(map, Enmap);
            if (hit) {
                EnshipLeft--;
                System.out.println("The Computer has " + EnshipLeft + " ships left.");
                if (EnshipLeft == 0) {
                    System.out.println("Congratulations, you have won the game! ");
                    break;
                }
            }
            hit = Enfire(map, Enmap);
            if (hit) {
                UserShipsLeft--;
                System.out.println("You have " + UserShipsLeft + " left in your navy!");
                if (UserShipsLeft == 0) {
                    System.out.println("Your fleet has been eliminated, the computer has beaten you! ");
                    break;
                }
            }
        }
        System.out.println("The computer's map looked like this at the end of the game: ");
        displayMap(Enmap);
        System.out.println("Your map looked like this at the end of the game: ");
        displayMap(map);
        System.out.print("User's Ships left: " + UserShipsLeft + " \n Computer's Ships left: " + EnshipLeft);
    }
}
