package neqsim.processSimulation.util.monitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import neqsim.processSimulation.processEquipment.separator.Separator;
import neqsim.processSimulation.processEquipment.separator.ThreePhaseSeparator;
import neqsim.processSimulation.processEquipment.stream.Stream;
import neqsim.processSimulation.processSystem.ProcessSystem;
import neqsim.thermo.system.SystemSrkEos;

public class SeparatorResponseTest {

  @Test
  void testWrite() {

    SystemSrkEos testSystem = new SystemSrkEos(298.0, 10.0);
    testSystem.addComponent("methane", 100.0);
    testSystem.addComponent("n-heptane", 100.0);
    testSystem.addComponent("water", 100.0);
    testSystem.setMixingRule("classic");
    testSystem.setMultiPhaseCheck(true);

    ProcessSystem processOps = new ProcessSystem();

    Stream inletStream = new Stream("inletStream", testSystem);
    inletStream.setName("feed stream");
    inletStream.setPressure(10.0, "bara");
    inletStream.setTemperature(20.0, "C");
    inletStream.setFlowRate(290.0, "kg/hr");

    Separator separator = new Separator("two phase separator", inletStream);
    separator.setInternalDiameter(0.05);

    ThreePhaseSeparator separator3phase =
        new ThreePhaseSeparator("three phase separator", inletStream);
    separator3phase.setInternalDiameter(0.05);

    processOps.add(inletStream);
    processOps.add(separator);
    processOps.add(separator3phase);
    processOps.run();

    String sepjson = separator.toJson();
    String sep3json = separator3phase.toJson();
    JsonObject jsonObject = JsonParser.parseString(sep3json).getAsJsonObject();
    Double reldens = jsonObject.getAsJsonObject("feed").getAsJsonObject("properties")
        .getAsJsonObject("oil").getAsJsonObject("relative density").get("value").getAsDouble();
    assertEquals(0.688292615281, reldens, 0.01);


  }
}
