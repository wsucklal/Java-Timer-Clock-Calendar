package Question2;

public abstract class Wheel<T> {

    private T value;

    //Sets value of the class
    public void setValue(T value){
        this.value = value;
    }

    // Gets the value of the class
    public T getValue() {
        return  value;
    }

    //Sets the value field to the minimum value
    public abstract void reset();

    //Return whether the last wheel step caused a rollover
    public  abstract boolean isRolledOver();

}
