import javax.swing.JOptionPane;

public class giuIntro {
    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("What is your name?");
        JOptionPane.showMessageDialog(null, "Hello " + name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("What is your age?")); // JOption returns a String so we have to convert to int
        JOptionPane.showMessageDialog(null, "your age: " + age);

        double height = Double.parseDouble(JOptionPane.showInputDialog("What is your height?"));
        JOptionPane.showMessageDialog(null, "your height: " + height);
    }
}