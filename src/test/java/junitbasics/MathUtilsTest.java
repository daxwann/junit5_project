package junitbasics;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) // default: creates an instance per method
class MathUtilsTest {
  MathUtils mathUtils;
  TestInfo testInfo;
  TestReporter testReporter;

  @BeforeAll
  static void beforeAllInit() {
    System.out.println("this runs before all");
  }

  @BeforeEach
  void init(TestInfo testInfo, TestReporter testReporter) {
    this.testInfo = testInfo;
    this.testReporter = testReporter;
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

  @Nested
  @DisplayName("Test MathUtils#add method")
  @Tag("Math")
  class testAdd {
    @Test
    @DisplayName("MathUtils#add should add negative numbers")
    void testAddNegative() {
      int expected = -3;
      int actual = mathUtils.add(-2, -1);

      assertEquals(expected, actual, () -> "The add method should add negative number");
    }

    @Test
    @DisplayName("MathUtils#add should add positive numbers")
    void testAddPositive() {
      int expected = 4;
      int actual = mathUtils.add(2, 2);

      assertEquals(expected, actual, () -> "The add method should add positive number");
    }
  }

  @RepeatedTest(3)
  @DisplayName("Test MathUtils#computeCircleRadius method")
  @Tag("Circle")
  void testComputeCircleRadius(RepetitionInfo repetitionInfo) {
    double testRadius = 10;
    System.out.println("repetition: " + repetitionInfo.getCurrentRepetition());
    assertEquals(Math.PI * testRadius * testRadius, mathUtils.computerCircleArea(testRadius), () -> "Should return area of circle");
  }

  @Test
  @DisplayName("Test MathUtils#muliplyMethod")
  @Tag("Math")
  void testMultiply() {
    System.out.println("Running " + this.testInfo.getDisplayName() + " with tags " + this.testInfo.getTags());
    testReporter.publishEntry("Running " + this.testInfo.getDisplayName() + " with tags " + this.testInfo.getTags());
    assertAll(
        () -> assertEquals(4, mathUtils.multiply(2, 2)),
        () -> assertEquals(-4, mathUtils.multiply(-2, 2)),
        () -> assertEquals(0, mathUtils.multiply(0, 4))
    );
  }

  @Test
  @DisplayName("Test MathUtils#divide method")
  @Tag("Math")
  void testDivide() {
    boolean isServerUp = true;
    assumeTrue(isServerUp);
    assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), () -> "Divide by 0 should throw");
  }

  @Test
  @Disabled
  @DisplayName("TDD method. should not run")
  void testDisabled() {
    fail("fail");
  }
}