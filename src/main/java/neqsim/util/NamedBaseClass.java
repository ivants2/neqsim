package neqsim.util;

/**
 * Abstract class for named objects.
 *
 * @author ASMF
 * @version $Id: $Id
 */
public abstract class NamedBaseClass implements NamedInterface, java.io.Serializable {
  private static final long serialVersionUID = 1L;
  public String name;

  /**
   * Constructor for NamedBaseClass
   *
   * @param name the name of the class
   */
  public NamedBaseClass(String name) {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   *
   * Getter for property name
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * {@inheritDoc}
   *
   * Setter for property name
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }
}
