package neqsim.thermo.phase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhaseGENRTLmodifiedWSTest {
  static PhaseGENRTLmodifiedWS p;

  @BeforeEach
  void setUp() {
    p = new PhaseGENRTLmodifiedWS();
  }

  @Test
  void testAddcomponent() {
    Assertions.assertEquals(0, p.getNumberOfComponents());

    p.addComponent("ethane", 0, 0, 0);
    Assertions.assertEquals(1, p.getNumberOfComponents());

    p.addComponent("methane", 0, 0, 0);
    Assertions.assertEquals(2, p.getNumberOfComponents());
  }
}