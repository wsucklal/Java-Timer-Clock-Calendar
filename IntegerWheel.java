package Question2;

import Question1.Rollable;

public class IntegerWheel extends Wheel implements Rollable {

    private int minValue;
    private int maxValue;

    //Constructor method that sets min value automatically to 0 given one paramater
    public IntegerWheel (int max){
    minValue = 0;
    maxValue =max;
    setValue(max);
    }

    //Constructor class that sets min value and max value given two paramaters
    public IntegerWheel(int min, int max){
        minValue = min;
        maxValue =max;
        setValue(min);
    }

    // Gets the min value of the class
    public int getMin(){
       return minValue;
    }

    // Gets the max value of the class
    public int getMax() {
        return maxValue;
    }

    //Sets the value field to the minimum value
    public void reset() {
        setValue(minValue);
    }

    //Return whether the last wheel step caused a rollover
    public boolean isRolledOver() {

        return ((Integer) (getValue()) + 1) > maxValue || ((Integer) (getValue()) - 1) < minValue;
    }

    //Rolls the wheel one step up, setting value back to the min value when it goes over max value
    public void rollUp() {

        if ((Integer)(getValue())+1>maxValue) {
           setValue(minValue);
        }
        else {
            setValue((Integer) (getValue()) + 1);
        }

    }

    //Rolls the wheel one step down, setting value back to the max when it goes under the min value
    public void rollDown() {

        if ((Integer)(getValue())-1<minValue) {
            setValue(maxValue);
        }
        else {
            setValue((Integer) (getValue()) - 1);
        }
    }
}
