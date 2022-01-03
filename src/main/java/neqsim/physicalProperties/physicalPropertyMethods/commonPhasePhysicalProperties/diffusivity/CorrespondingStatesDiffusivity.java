package neqsim.physicalProperties.physicalPropertyMethods.commonPhasePhysicalProperties.diffusivity;

/**
 * <p>CorrespondingStatesDiffusivity class.</p>
 *
 * @author Even Solbraa
 */
public class CorrespondingStatesDiffusivity extends Diffusivity {

    private static final long serialVersionUID = 1000;

    double[][] binaryDiffusionCoeffisients, binaryLennardJonesOmega;

    /**
     * Creates new Conductivity
     */
    public CorrespondingStatesDiffusivity() {}

    /**
     * <p>Constructor for CorrespondingStatesDiffusivity.</p>
     *
     * @param phase a {@link neqsim.physicalProperties.physicalPropertySystem.PhysicalPropertiesInterface} object
     */
    public CorrespondingStatesDiffusivity(
            neqsim.physicalProperties.physicalPropertySystem.PhysicalPropertiesInterface phase) {
        super(phase);
        binaryDiffusionCoeffisients = new double[phase.getPhase().getNumberOfComponents()][phase
                .getPhase().getNumberOfComponents()];
    }

    /** {@inheritDoc} */
    @Override
    public double calcBinaryDiffusionCoefficient(int i, int j, int method) {

        if (phase.getPhase().getPhaseType() == 0) {
            binaryDiffusionCoeffisients[i][j] = 1.0e-4 * 9.89e-8
                    * Math.pow(phase.getViscosity() * 1e3, -0.907)
                    * Math.pow(
                            1.0 / phase.getPhase().getComponents()[i].getNormalLiquidDensity()
                                    * phase.getPhase().getComponents()[i].getMolarMass() * 1000,
                            -0.45)
                    * Math.pow(
                            1.0 / phase.getPhase().getComponents()[j].getNormalLiquidDensity()
                                    * phase.getPhase().getComponents()[j].getMolarMass() * 1000,
                            0.265)
                    * phase.getPhase().getTemperature();
            // System.out.println("liq diffusivity " +binaryDiffusionCoeffisients[i][j] );
            return binaryDiffusionCoeffisients[i][j];
        } else {
            binaryDiffusionCoeffisients[i][j] = 1.8e-5 / phase.getPhase().getPressure();
            // System.out.println("gas diffusivity " +binaryDiffusionCoeffisients[i][j] );
            return binaryDiffusionCoeffisients[i][j];
        }
    }

}
