package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {


    @Test
    public void summaryStatistics() throws Exception {


    }
    @Test(expected = IllegalArgumentException.class)
    public void constructorWithEmptyAgrumentTest(){
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

    }


    @Test
    public void testAddTempsWithArray1() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        double[] addSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 14;
        int actualResult = seriesAnalysis.addTemps(addSeries);
        assertEquals(expResult, actualResult);

    }

    @Test
    public void testFindTempsGreaterThen2() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-4);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));

    }

    @Test
    public void testFindTempsGreaterThen1() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(10000);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));

    }


    @Test
    public void testFindTempsLessThen3() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        double[] actualResult = seriesAnalysis.findTempsLessThen(10000);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));

    }

    @Test
    public void testFindTempsLessThen2() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsLessThen(-4);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));

    }

    @Test
    public void testFindTempsLessThen1() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-3.0, -1.0, 2.0, 137.5};
        double[] actualResult = seriesAnalysis.findTempsLessThen(138);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));

    }


    @Test
    public void testFindTempClosestToValueWithArray2() {
        double[] temperatureSeries = {-2, 22};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 22;
        double actualResult = seriesAnalysis.findTempClosestToValue(10);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithArray1() {
        double[] temperatureSeries = {-3, -2, -2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -2;
        double actualResult = seriesAnalysis.findTempClosestToValue(10);
        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test
    public void testFindTempClosestToZeroWithArray3() {
        double[] temperatureSeries = {-2, -2, -2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -2;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithArray2() {
        double[] temperatureSeries = {-1, -1, -1, -1, -1, 1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test
    public void testFindTempClosestToZeroWithArray1() {
        double[] temperatureSeries = {5, 1, 2, 3, 4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test
    public void testDeviationWithArray2() {
        double[] temperatureSeries = {1, 2, 3, 4, 5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.4142135;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationWithArray1() {
        double[] temperatureSeries = {-235, -103, 3, 100, 250};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 166.31175;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testMaxWithArray() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 843;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testMinWithNegativeValue() {
        double[] temperatureSeries = {-273.1};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Test
    public void testMinWithArray() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -3.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }


    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        //     System.out.println(Arrays.toString(temperatureSeries));
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }


}
