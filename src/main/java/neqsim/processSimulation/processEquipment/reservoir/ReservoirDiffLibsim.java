package neqsim.processSimulation.processEquipment.reservoir;

import java.util.UUID;
import neqsim.processSimulation.processEquipment.ProcessEquipmentBaseClass;
import neqsim.thermo.system.SystemInterface;

/**
 * <p>
 * ReservoirDiffLibsim class.
 * </p>
 *
 * @author Even Solbraa
 * @version $Id: ReservoirDiffLibsim.java 1234 2024-05-31 10:00:00Z esolbraa $
 */
public class ReservoirDiffLibsim extends ProcessEquipmentBaseClass {
  private static final long serialVersionUID = 1000;

  public ReservoirDiffLibsim(String name, SystemInterface reservoirFluid) {
    super(name);
  }

  /** {@inheritDoc} */
  @Override
  public void run(UUID id) {

  }

}
