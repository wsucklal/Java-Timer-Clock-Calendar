package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class DayWheel extends Wheel implements Rollable {

    private int minValue;
    private int maxValue;
    private int initialDay;

    //Constructor method that sets the max value according to the month  length and value
    public DayWheel(int day,int monthLength){
        setValue(day);
        initialDay = day;
        minValue =  1;
        maxValue = monthLength;
    }

    //Sets the max value given the month length
    public void setMonthDays(int monthLength) {
        maxValue = monthLength;
    }

    // Gets the min value of the class
    public int getMin(){
        return minValue;
    }

    // Gets the max value of the class
    public int getMax() {
        return maxValue;
    }

    //Rolls the wheel one step up, setting value back to the min value when it goes over max value
    @Override
    public void rollUp() {

        if ((Integer)(getValue())+1>maxValue) {

            setValue(minValue);

        }
        else {
            setValue((Integer) (getValue()) + 1);
        }

    }

    //Rolls the wheel one step down, setting value back to the min value when it goes over max value
    @Override
    public void rollDown() {
        if ((Integer)(getValue())-1<minValue) {

            setValue(maxValue);

        }
        else {
            setValue((Integer) (getValue()) - 1);
        }
    }

    //Sets the value field to the initial day
    @Override
    public void reset() {
        setValue(initialDay);
    }

    //Return whether the last wheel step caused a rollover
    @Override
    public boolean isRolledOver() {
        return ((Integer) (getValue()) + 1) > maxValue || ((Integer) (getValue()) - 1) < minValue;
    }
}
