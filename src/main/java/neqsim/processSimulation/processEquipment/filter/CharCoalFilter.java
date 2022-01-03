package neqsim.processSimulation.processEquipment.filter;

import neqsim.processSimulation.processEquipment.stream.StreamInterface;

/**
 * <p>CharCoalFilter class.</p>
 *
 * @author asmund
 * @version $Id: $Id
 */
public class CharCoalFilter extends Filter {
    /**
     * <p>Constructor for CharCoalFilter.</p>
     *
     * @param inStream a {@link neqsim.processSimulation.processEquipment.stream.StreamInterface} object
     */
    public CharCoalFilter(StreamInterface inStream) {
        super(inStream);
    }
}
