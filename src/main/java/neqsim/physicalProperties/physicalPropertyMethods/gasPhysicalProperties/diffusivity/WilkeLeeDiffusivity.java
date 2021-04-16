/*
 * Conductivity.java
 *
 * Created on 1. november 2000, 19:00
 */

package neqsim.physicalProperties.physicalPropertyMethods.gasPhysicalProperties.diffusivity;

/**
 *
 * @author Even Solbraa
 * @version
 */
public class WilkeLeeDiffusivity extends Diffusivity {

    private static final long serialVersionUID = 1000;

    double[][] binaryDiffusionCoeffisients, binaryLennardJonesOmega;

    /** Creates new Conductivity */
    public WilkeLeeDiffusivity() {
    }

    public WilkeLeeDiffusivity(neqsim.physicalProperties.physicalPropertySystem.PhysicalPropertiesInterface gasPhase) {
        super(gasPhase);
        binaryDiffusionCoeffisients = new double[gasPhase.getPhase().getNumberOfComponents()][gasPhase.getPhase()
                .getNumberOfComponents()];
        binaryLennardJonesOmega = new double[gasPhase.getPhase().getNumberOfComponents()][gasPhase.getPhase()
                .getNumberOfComponents()];
    }

    public double calcBinaryDiffusionCoefficient(int i, int j, int method) {
        // method - estimation method
        // if(method==? then)
        // remember this is the Fick's diffusion coefficients
        // to get the Maxwell-Stefan coefficient - multiply by gamma
        double A2 = 1.06036, B2 = 0.15610, C2 = 0.19300, D2 = 0.47635, E2 = 1.03587, F2 = 1.52996, G2 = 1.76474,
                H2 = 3.89411;
        double tempVar2 = gasPhase.getPhase().getTemperature() / binaryEnergyParameter[i][j];
        binaryLennardJonesOmega[i][j] = A2 / Math.pow(tempVar2, B2) + C2 / Math.exp(D2 * tempVar2)
                + E2 / Math.exp(F2 * tempVar2) + G2 / Math.exp(H2 * tempVar2);
        binaryDiffusionCoeffisients[i][j] = (3.03 - (0.98 / Math.sqrt(binaryMolecularMass[i][j])) * 1.0e-3
                * Math.pow(gasPhase.getPhase().getTemperature(), 1.5))
                / (gasPhase.getPhase().getPressure() * Math.sqrt(binaryMolecularMass[i][j])
                        * Math.pow(binaryMolecularDiameter[i][j], 2.0) * binaryLennardJonesOmega[i][j]);
        return binaryDiffusionCoeffisients[i][j] * 1e-4;
    }

}
