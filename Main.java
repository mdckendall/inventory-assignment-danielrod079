import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
    String name;
    String serialNum;
    int cost;

    //The inventory in the list.
    public Inventory(String name, String serialNum, int cost){
        this.name = name;
        this.serialNum = serialNum;
        this.cost = cost;
    }

    public void newName(String name) {
        this.name = name;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void newValue(int cost) {
        this.cost = cost;
    }
}

class Main {
    public static void main(String[] args) {
        int choice = 0;
        String name;
        String serialNum;
        int cost;
        Scanner input = new Scanner(System.in);
        ArrayList <Inventory> Item = new ArrayList <>();

        while(choice != 5){
            System.out.println(
                    "Press 1 to add an item.\n" +
                    "Press 2 to delete an item.\n" +
                    "Press 3 to update an item.\n" +
                    "Press 4 to show all the items.\n" +
                    "Press 5 to quit the program.");
            choice = Integer.parseInt(input.nextLine());

            switch (choice){
                //Creating the item and information.
                case 1 :
                    System.out.println("Enter the name:");
                    name = input.nextLine();
                    System.out.println("Enter the serial number:");
                    serialNum = input.nextLine();
                    System.out.println ("Enter the value in dollars (whole number):");
                    cost = Integer.parseInt(input.nextLine());
                    Inventory item = new Inventory(name, serialNum, cost);
                    Item.add(item);
                    break;

                    //Deleting the item.
                case 2:
                    System.out.println("Enter the serial number of the item to delete:");
                    String serial = input.nextLine();
                    for (int i = 0 ; i < Item.size(); i++ ){
                        if(Item.get(i).getSerialNum().contains(serial)){
                            Item.remove(i);
                        }
                    }
                    break;

                    //Changing the item information.
                case 3:
                    System.out.println("Enter the serial number of the item to change:");
                    serial = input.nextLine();
                    for (int i = 0 ; i < Item.size(); i++ ){
                        if(Item.get(i).getSerialNum().contains(serial)){
                            System.out.println("Enter the new name:");
                            name = input.nextLine();
                            Item.get(i).newName(name);
                            System.out.println("Enter the new value in dollars (whole number):");
                            cost = Integer.parseInt(input.nextLine());
                            Item.get(i).newValue(cost);
                        }
                    }
                    break;

                    //Shows all items.
                case 4:
                    for (int i = 0 ; i < Item.size(); i++ ){
                        System.out.print(Item.get(i).name + ",");
                        System.out.print(Item.get(i).serialNum + ",");
                        System.out.println(Item.get(i).cost);
                    }
                    break;
                    //if choice == 5, program ends.
            }
        }
    }
}
