/*
 * DoubleCloneable.java
 *
 * Created on 3. juni 2001, 20:19
 */

package neqsim.util.util;

/**
 * <p>DoubleCloneable class.</p>
 *
 * @author  esol
 */
public class DoubleCloneable implements Cloneable {

    private static final long serialVersionUID = 1000;

    double doubleValue;

    /**
     * Creates new DoubleCloneable
     */
    public DoubleCloneable() {
    }

    /**
     * <p>Constructor for DoubleCloneable.</p>
     *
     * @param val a double
     */
    public DoubleCloneable(double val) {
        this.doubleValue = val;
    }

    /** {@inheritDoc} */
    @Override
    public DoubleCloneable clone() {
        DoubleCloneable clonedSystem = null;
        try {
            clonedSystem = (DoubleCloneable) super.clone();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return clonedSystem;
    }

    /**
     * <p>set.</p>
     *
     * @param val a double
     */
    public void set(double val) {
        doubleValue = val;
    }

    /**
     * <p>doubleValue.</p>
     *
     * @return a double
     */
    public double doubleValue() {
        return doubleValue;
    }
}
