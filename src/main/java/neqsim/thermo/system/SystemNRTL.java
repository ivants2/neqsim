package neqsim.thermo.system;

import neqsim.thermo.phase.PhaseGENRTL;
import neqsim.thermo.phase.PhasePureComponentSolid;
import neqsim.thermo.phase.PhaseSrkEos;

/**
 * This class defines a thermodynamic system using the SRK EoS for gas and NRTL for liquids.
 *
 * @author Even Solbraa
 * @version $Id: $Id
 */
public class SystemNRTL extends SystemEos {
  private static final long serialVersionUID = 1000;

  /**
   * <p>
   * Constructor for SystemNRTL.
   * </p>
   */
  public SystemNRTL() {
    super();
    modelName = "NRTL-GE-model";
    attractiveTermNumber = 0;
    phaseArray[0] = new PhaseSrkEos();
    for (int i = 1; i < numberOfPhases; i++) {
      phaseArray[i] = new PhaseGENRTL(); // modifiedWS();
    }
  }

  /**
   * <p>
   * Constructor for SystemNRTL.
   * </p>
   *
   * @param T The temperature in unit Kelvin
   * @param P The pressure in unit bara (absolute pressure)
   */
  public SystemNRTL(double T, double P) {
    super(T, P);
    attractiveTermNumber = 0;
    modelName = "NRTL-GE-model";
    phaseArray[0] = new PhaseSrkEos();
    phaseArray[0].setTemperature(T);
    phaseArray[0].setPressure(P);
    for (int i = 1; i < numberOfPhases; i++) {
      phaseArray[i] = new PhaseGENRTL(); // new PhaseGENRTLmodifiedWS();
      phaseArray[i].setTemperature(T);
      phaseArray[i].setPressure(P);
    }
  }

  /**
   * <p>
   * Constructor for SystemNRTL.
   * </p>
   *
   * @param T The temperature in unit Kelvin
   * @param P The pressure in unit bara (absolute pressure)
   * @param checkForSolids Set true to do solid phase check and calculations
   */
  public SystemNRTL(double T, double P, boolean checkForSolids) {
    this(T, P);
    attractiveTermNumber = 0;
    setNumberOfPhases(4);
    modelName = "NRTL-GE-model";
    solidPhaseCheck = checkForSolids;

    phaseArray[0] = new PhaseSrkEos();
    phaseArray[0].setTemperature(T);
    phaseArray[0].setPressure(P);
    for (int i = 1; i < numberOfPhases; i++) {
      phaseArray[i] = new PhaseGENRTL(); // new PhaseGENRTLmodifiedWS();
      phaseArray[i].setTemperature(T);
      phaseArray[i].setPressure(P);
    }

    if (solidPhaseCheck) {
      // System.out.println("here first");
      phaseArray[numberOfPhases - 1] = new PhasePureComponentSolid();
      phaseArray[numberOfPhases - 1].setTemperature(T);
      phaseArray[numberOfPhases - 1].setPressure(P);
      phaseArray[numberOfPhases - 1].setRefPhase(phaseArray[1].getRefPhase());
    }
  }

  /** {@inheritDoc} */
  @Override
  public SystemNRTL clone() {
    SystemNRTL clonedSystem = null;
    try {
      clonedSystem = (SystemNRTL) super.clone();
    } catch (Exception ex) {
      logger.error("Cloning failed.", ex);
    }

    // for(int i = 0; i < numberOfPhases; i++) {
    // clonedSystem.phaseArray[i] = (PhaseInterface) phaseArray[i].clone();
    // }

    return clonedSystem;
  }
}
