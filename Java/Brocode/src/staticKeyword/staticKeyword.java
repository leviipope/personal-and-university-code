package staticKeyword;

public class staticKeyword {
    public static void main(String[] args) {

        // static = modifier. A single copy of a variable/method is created and shared.
        //          The class "own" the static member

        Friend friend1 = new Friend("Spongebob");
        Friend friend2 = new Friend("Patrick");
        Friend friend3 = new Friend("Squidward");
        Friend friend4 = new Friend("Sandy");


        System.out.println(Friend.numberOfFriends); // best way to access a static attr. is through the class who owns the static member

        Friend.displayFriends();
    }
}
