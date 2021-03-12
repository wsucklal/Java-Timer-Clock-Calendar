package Question2;

import Question1.CounterDisplay;

public class IntegerWheelCounter implements CounterDisplay {

    private IntegerWheel[] integerWheel = new IntegerWheel[3];
    private int noOfWheels = 3;

    //Constructor Class that constructs
    public IntegerWheelCounter(IntegerWheel wheelThree, IntegerWheel wheelTwo, IntegerWheel wheelOne){
        integerWheel[0]=wheelThree;
        integerWheel[1]=wheelTwo;
        integerWheel[2]=wheelOne;
    }

    //resets the value field to the minimum value for each wheel
    public void reset() {

        for (int i = 0; i < noOfWheels;i++) {
            integerWheel[i].reset();
        }

    }

    //Randomizes the values of the wheel of the counter
    public void shuffle() {

        integerWheel[0].setValue(((int)(Math.random() * (integerWheel[0].getMax() - integerWheel[0].getMin() + 1) + integerWheel[0].getMin())));
        integerWheel[1].setValue(((int)(Math.random() * (integerWheel[1].getMax() - integerWheel[1].getMin() + 1) + integerWheel[1].getMin())));
        integerWheel[2].setValue(((int)(Math.random() * (integerWheel[2].getMax() - integerWheel[2].getMin() + 1) + integerWheel[2].getMin())));

    }

    //Increases the Integer Wheels with respect to each other once the previous wheel is rolled over
    public void increase() {

        if(((Integer)(integerWheel[1].getValue())+1>integerWheel[1].getMax())&&((Integer)(integerWheel[2].getValue())+1>integerWheel[2].getMax())){
            integerWheel[0].rollUp();
        }

        if((Integer)(integerWheel[2].getValue())+1>integerWheel[2].getMax()){
            integerWheel[1].rollUp();
        }

        integerWheel[2].rollUp();

    }

    //Decreases the Integer Wheels with respect to each other once the previous wheel is rolled over
    public void decrease() {

        if(((Integer)(integerWheel[1].getValue())-1>integerWheel[1].getMin())&&((Integer)(integerWheel[2].getValue())-1>integerWheel[2].getMin())){
            integerWheel[0].rollDown();
        }

        if((Integer)(integerWheel[2].getValue())-1>integerWheel[2].getMin()){
            integerWheel[1].rollDown();
        }

        integerWheel[2].rollDown();

    }

    //Prints Intger Wheel with clock format
    public String toString() {
        return ( String.format("%02d", integerWheel[0].getValue()) + ":" + String.format("%02d", integerWheel[1].getValue()) + ":" + String.format("%02d", integerWheel[2].getValue()));
    }
}
