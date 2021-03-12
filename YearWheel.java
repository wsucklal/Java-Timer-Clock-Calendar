package Question3;

import Question1.Rollable;
import Question2.Wheel;

public class YearWheel extends Wheel implements Rollable {

    private int yearInitial;

    //Constructor method sets the value with given number
    public YearWheel(int year){
        setValue(year);
        yearInitial =  year;
    }

    //Checks if given year is a leap year
    public boolean isLeapYear(){
      return  (((Integer)getValue() % 4 == 0) && ((Integer)getValue() % 100 != 0) || ((Integer)getValue() % 400 == 0));
    }

    //Sets the value field to the initial year
    @Override
    public void reset() {
        setValue(yearInitial);
    }

    //Return whether the last wheel step caused a rollover
    @Override
    public boolean isRolledOver() {
        return false;
    }

    //Rolls the wheel one step up, setting value back to the min value when it goes over max value
    @Override
    public void rollUp() {
        setValue((Integer)getValue() + 1);
    }

    //Rolls the wheel one step down, setting value back to the min value when it goes over max value
    @Override
    public void rollDown() { setValue((Integer)getValue() - 1);
    }
}
