package staticKeyword;

public class Friend {

    String name;
    static int numberOfFriends; // all the instances of the friends class are forced to share this static member

    Friend(String name) {
        this.name = name;
        numberOfFriends++;
    }

    static void displayFriends() {
        System.out.println("you have: " + numberOfFriends + " friends");
    }
}
