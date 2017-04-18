/*
Author: Darian
Date Modified: April 18, 2017
IDE: Netbeans 8.2
Program: Convert between linear measurment units
File: Converter to convert units
 */
package converter;

/**
 * Converter to convert linear units
 * @author Meep3_000
 */
public class Converter {
    private static final double CENTIMETRES = 0.01f;//Declaring conversion constants based on how many meters are in it
    private static final double METRES = 1.00f;
    private static final double KILOMETRES = 1000.00f;
    private static final double INCHES = 0.0254f;
    private static final double FEET = 0.3048f;
    private static final double YARDS = 0.9144f;
    private static final double MILES = 1609.34f;
    
    private final double from;
    private final double to;
    
    /**
     * Converts unit enum to unit double
     * @param unit Enum version of unit
     * @return Double version of unit
     */
    private double unitEnumToDouble(Units unit){
        switch(unit){
            case CENTIMETRES:
                return Converter.CENTIMETRES;
            case METRES:
                return Converter.METRES;
            case KILOMETRES:
                return Converter.KILOMETRES;
            case INCHES:
                return Converter.INCHES;
            case FEET:
                return Converter.FEET;
            case YARDS:
                return Converter.YARDS;
            case MILES:
                return Converter.MILES;
            default:
                return 0.0f;
        }
    }
    
    /**
     * Create a new unit converter
     * @param from Unit to convert from
     * @param to Unit to convert to
     */
    public Converter(Units from, Units to){
        this.from = unitEnumToDouble(from);
        this.to = unitEnumToDouble(to);
    }
    
    /**
     * Convert a unit
     * @param value Quantity to convert
     * @return Quantity in new unit
     */
    public double convert(double value){
        return (value * from) / to;//Basicly converts to metres and back, but it was extendable
    }
}

