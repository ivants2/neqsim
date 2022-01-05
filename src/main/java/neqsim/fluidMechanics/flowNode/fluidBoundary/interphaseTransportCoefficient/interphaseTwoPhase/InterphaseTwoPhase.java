package neqsim.fluidMechanics.flowNode.fluidBoundary.interphaseTransportCoefficient.interphaseTwoPhase;

import neqsim.fluidMechanics.flowNode.FlowNodeInterface;
import neqsim.fluidMechanics.flowNode.fluidBoundary.interphaseTransportCoefficient.InterphaseTransportCoefficientBaseClass;

/**
 * <p>
 * InterphaseTwoPhase class.
 * </p>
 *
 * @author esol
 * @version $Id: $Id
 */
public class InterphaseTwoPhase extends InterphaseTransportCoefficientBaseClass {
    private static final long serialVersionUID = 1000;

    public InterphaseTwoPhase() {}

    /**
     * <p>
     * Constructor for InterphaseTwoPhase.
     * </p>
     *
     * @param node a {@link neqsim.fluidMechanics.flowNode.FlowNodeInterface} object
     */
    public InterphaseTwoPhase(FlowNodeInterface node) {
        // flowNode = node;
    }
}
