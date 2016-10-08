package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    public double[] getTemperatureSeries() {
        return temperatureSeries;
    }

    public void setTemperatureSeries(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
    }

    protected double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        throw new IllegalArgumentException("List is empty");
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
        this.setTemperatureSeries(temperatureSeries);
    }

    public double average() {
        double avg = 0;
        for (double tmp : temperatureSeries) {
            avg += tmp / temperatureSeries.length;
        }
        return avg;
    }

    public double deviation() {
        double avg = average();
        double dev = 0;
        for (double tmp : temperatureSeries) {
            dev += (tmp - avg) * (tmp - avg) / temperatureSeries.length;

        }

        return Math.sqrt(dev);
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
        double t = Math.abs(temperatureSeries[0]);
        for (double tmp : temperatureSeries) {
            if (Math.abs(tmp) < t) {
                t = Math.abs(tmp);
            }
        }
        for (double tmp : temperatureSeries) {
            if (tmp == t) {
                return tmp;
            }
        }
        return -t;
    }

    public double findTempClosestToValue(double tempValue) {
        double t = Math.abs(temperatureSeries[0] - tempValue);
        for (double tmp : temperatureSeries) {
            if (Math.abs(tmp - tempValue) < t) {
                t = Math.abs(tmp - tempValue);
            }
        }
        for (double tmp : temperatureSeries) {
            if (tmp - t == tempValue) {
                return tmp;
            }
        }
        return tempValue - t;
    }


    public double[] findTempsLessThen(double tempValue) {
        int c = 0;
        for (double tmp : temperatureSeries) {
            if (tmp < tempValue) {
                c++;
            }
        }
        double[] tempsLessThanValue = new double[c];
        int index = 0;
        for (double tmp : temperatureSeries) {
            if (tmp < tempValue) {
                tempsLessThanValue[index] = tmp;
                index++;
            }
        }
        return tempsLessThanValue;
    }

    public double[] findTempsGreaterThen(double tempValue) {

        int c = 0;
        for (double tmp : temperatureSeries) {
            if (tmp > tempValue) {
                c++;
            }
        }
        double[] tempsGreaterThanValue = new double[c];
        int index = 0;
        for (double tmp : temperatureSeries) {
            if (tmp > tempValue) {
                tempsGreaterThanValue[index] = tmp;
                index++;
            }
        }
        return tempsGreaterThanValue;
    }

    public TempSummaryStatistics summaryStatistics() {
        TempSummaryStatistics summary = new TempSummaryStatistics(average(), deviation(), min(), max());
        return summary;
    }

    public int addTemps(double... temps) {
        double[] resizedTemperatureSeries = new double[temperatureSeries.length + temps.length];
        int sum = 0;
        for (int i = 0; i < temperatureSeries.length; ++i) {
            sum += temperatureSeries[i];
            resizedTemperatureSeries[i] = temperatureSeries[i];
        }
        for (int i = 0; i < temps.length; ++i) {
            sum += temps[i];
            resizedTemperatureSeries[temperatureSeries.length - 1 + i] = temps[i];
        }
        this.setTemperatureSeries(resizedTemperatureSeries);

        return sum;
    }
}
