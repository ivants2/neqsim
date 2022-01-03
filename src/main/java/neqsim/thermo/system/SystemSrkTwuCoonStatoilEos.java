package neqsim.thermo.system;

/**
 * <p>SystemSrkTwuCoonStatoilEos class.</p>
 *
 * @author asmund
 * @version $Id: $Id
 */
public class SystemSrkTwuCoonStatoilEos extends SystemSrkEos {

    private static final long serialVersionUID = 1000;

    /**
     * Creates a thermodynamic system using the SRK equation of state.
     */
    // SystemSrkEos clonedSystem;
    public SystemSrkTwuCoonStatoilEos() {
        super();
        modelName = "TwuCoonStatoil-EOS";
        attractiveTermNumber = 18;
    }

    /**
     * <p>Constructor for SystemSrkTwuCoonStatoilEos.</p>
     *
     * @param T a double
     * @param P a double
     */
    public SystemSrkTwuCoonStatoilEos(double T, double P) {
        super(T, P);
        modelName = "TwuCoonStatoil-EOS";
        attractiveTermNumber = 18;
    }

    /**
     * <p>Constructor for SystemSrkTwuCoonStatoilEos.</p>
     *
     * @param T a double
     * @param P a double
     * @param solidCheck a boolean
     */
    public SystemSrkTwuCoonStatoilEos(double T, double P, boolean solidCheck) {
        super(T, P, solidCheck);
        modelName = "TwuCoonStatoil-EOS";
        attractiveTermNumber = 18;
    }

    /** {@inheritDoc} */
    @Override
    public SystemSrkTwuCoonStatoilEos clone() {
        SystemSrkTwuCoonStatoilEos clonedSystem = null;
        try {
            clonedSystem = (SystemSrkTwuCoonStatoilEos) super.clone();
        } catch (Exception e) {
            logger.error("Cloning failed.", e);
        }

//        
//        for(int i = 0; i < numberOfPhases; i++) {
//            clonedSystem.phaseArray[i] = (PhaseInterface) phaseArray[i].clone();
//        }

        return clonedSystem;
    }
}
