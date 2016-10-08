package ua.edu.ucu.tempseries;

import java.util.Arrays;

public class TemperatureSeriesAnalysis {
    protected double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (temperatureSeries.length == 0 ) {
            throw new IllegalArgumentException("List is empty");
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
        return 0;
    }

    public double max() {
        return 0;
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
