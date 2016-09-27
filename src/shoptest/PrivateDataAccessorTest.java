package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static auxiliary.testclasses.PrivateDataAccessor.*;
import static javafx.scene.input.KeyCode.T;
import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.26..
 */
public class PrivateDataAccessorTest {

    private String testString;
    private ArrayList<Integer> testIntList;

    @Before
    public void setUp() throws Exception {
        testString = "Test text.";
        Integer[] temp = {1, 2, 6, 4};
        testIntList = new ArrayList<>(Arrays.asList(temp));
    }

    @After
    public void tearDown() throws Exception {
        testString = null;
        testIntList = null;
    }

    @Test
    public void getObjectFromCertainMethodTest() throws Exception {
        int strLength = (int)getObjectFromCertainMethod(String.class.getMethod("length"), testString);
        assertEquals(testString.length(), strLength);
    }

    @Test
    public void getObjectFromCertainMethodWithMethodSearchTest() throws Exception {
        Class strClass = (Class)getObjectFromCertainMethod("getClass", String.class.getMethods(), testString);
        assertEquals(String.class, strClass);
    }

    @Test
    public void getObjectFromCertainMethodWithMoreParameterTest() throws Exception {
        Object[] parameters = {'s', 0};
        int index = (int)getObjectFromCertainMethod(String.class.getDeclaredMethod("indexOf", int.class, int.class),
                testString, parameters);
        assertEquals(2, index);
    }

    @Test
    public void getObjectFromCertainMethodWithOneParameterTest() throws Exception {
        int index = (int)getObjectFromCertainMethod("indexOf", String.class.getDeclaredMethods(), testString, 's');
        assertEquals(2, index);
    }

    @Test
    public void setObjectInCertainMethodTest() throws Exception {
        Comparator<Integer> integerComparator = Integer::compareTo;
        setObjectInCertainMethod(ArrayList.class.getDeclaredMethod("sort", Comparator.class), testIntList,
                integerComparator);
        assertEquals((Integer) 4, testIntList.get(2));
    }

    @Test
    public void setObjectInCertainMethodWithMethodSearchTest() throws Exception {
        int sizeOfList = testIntList.size();
        Object[] args = {1, 10};
        setObjectInCertainMethod("add", ArrayList.class.getDeclaredMethods(), testIntList, args);
        assertEquals(sizeOfList + 1, testIntList.size());
    }
}