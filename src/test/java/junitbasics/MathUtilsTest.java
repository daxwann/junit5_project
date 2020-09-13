package junitbasics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

  @Test
  void testAdd() {
    MathUtils mathUtils = new MathUtils();

    int expected = 2;
    int actual = mathUtils.add(1, 1);

    assertEquals(expected, actual, "The add method should add two numbers");
  }

  @Test
  void testComputeCircleRadius() {
    MathUtils mathUtils = new MathUtils();
    double testRadius = 10;

    assertEquals(Math.PI * testRadius * testRadius, mathUtils.computerCircleArea(testRadius), "Should return area of circle");
  }

}