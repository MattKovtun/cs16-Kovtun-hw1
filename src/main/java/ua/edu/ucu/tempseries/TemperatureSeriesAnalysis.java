package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    protected double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("List is empty");
        }

        for (double tmp : temperatureSeries) {
            if (tmp < -273) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = temperatureSeries;
    }

    public double average() {
        double avg = 0;
        for (double tmp : temperatureSeries) {
            avg += tmp / temperatureSeries.length;
        }

        return avg;
    }

    public double deviation() {
        return 0;
    }

    public double min() {
        double minimalValue = temperatureSeries[0];
        for (double tmp : temperatureSeries) {
            if (tmp < minimalValue) {
                minimalValue = tmp;
            }
        }
        return minimalValue;
    }

    public double max() {
        double maximumValue = temperatureSeries[0];
        for (double tmp : temperatureSeries) {
            if (tmp > maximumValue) {
                maximumValue = tmp;
            }
        }
        return maximumValue;
    }


    public double findTempClosestToZero() {
        return 0;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
