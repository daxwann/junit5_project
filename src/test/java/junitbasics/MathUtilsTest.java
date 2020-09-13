package junitbasics;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
  MathUtils mathUtils;

  @BeforeAll
  static void beforeAllInit() {
    System.out.println("this runs before all");
  }

  @BeforeEach
  void init() {
    mathUtils = new MathUtils();
  }

  @AfterEach
  void cleanUp() {
    System.out.println("Cleaning up...");
  }

  @AfterAll
  static void afterAllTearDown() {
    System.out.println("this runs after all");
  }

  @Test
  void testAdd() {
    int expected = 2;
    int actual = mathUtils.add(1, 1);

    assertEquals(expected, actual, "The add method should add two numbers");
  }

  @Test
  void testComputeCircleRadius() {
    double testRadius = 10;

    assertEquals(Math.PI * testRadius * testRadius, mathUtils.computerCircleArea(testRadius), "Should return area of circle");
  }

  @Test
  void testDivide() {
    assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by 0 should throw");
  }
}