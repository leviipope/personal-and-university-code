package org.example;

/**
 * The class representing a vector.
 * @author Kinga
 * @version 1.0
 * @since 2024.11.14.
 * @see <a href="https://hu.wikipedia.org/wiki/Vektor"></a>
 */
public class Vector implements IColored{

    /**
     * the field representing the x coordinate of the vector
     */
    private double x;
    /**
     * The field representing the y coordindate of the vector
     */
    private double y;
    /**
     * The field representing the color of the vector
     */
    private EnumColor color;

    /**
     * The constructor for the Vector class
     * @param y the y coordinate of the vector
     * @param x the x coordinate of the vector
     * @throws ExceptionVectorLength if the length is shorter than 1 it throws the exception
     */
    public Vector(double y, double x) throws ExceptionVectorLength{
        this.y = y;
        this.x = x;
        this.color = EnumColor.BLACK;
        if(this.getLength() < 1) throw new ExceptionVectorLength();
    }

    /**
     * @return the x coordinate of the vector
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y coordinate of the vector
     */
    public double getY() {
        return y;
    }

    /**
     * @return the color of the vector
     */
    @Override
    public EnumColor getColor() {
        return null;
    }

    /**
     * Sets the color of the vector to the given color
     * @param color a color value from the EnumColor enum
     */
    public void setColor(EnumColor color) {
        this.color = color;
    }

    /**
     * @return the length of the vector
     */
    public double getLength(){
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
    }

    /**
     * @return the length of the vector
     * {@code sqrt(x*x + y*y)}
     * @deprecated the formula used to calculate the length is outdated
     */
    public double getOldLength(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    /**
     * @return the values of the class as a string object
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vector{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
