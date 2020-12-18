/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neqsim.processSimulation.util.example;

import neqsim.processSimulation.processEquipment.compressor.Compressor;
import neqsim.processSimulation.processEquipment.heatExchanger.Cooler;
import neqsim.processSimulation.processEquipment.heatExchanger.Heater;
import neqsim.processSimulation.processEquipment.mixer.Mixer;
import neqsim.processSimulation.processEquipment.separator.Separator;
import neqsim.processSimulation.processEquipment.stream.Stream;
import neqsim.processSimulation.processEquipment.stream.StreamInterface;
import neqsim.processSimulation.processEquipment.util.Recycle;
import neqsim.processSimulation.processEquipment.valve.ThrottlingValve;

/**
 *
 * @author esol
 */
public class propaneTwoStageCoolingCycle {

    private static final long serialVersionUID = 1000;

    public static void main(String args[]) {

        neqsim.thermo.system.SystemInterface testSystem = new neqsim.thermo.system.SystemPrEos((273.15 + 30.0), 10.79);
        //testSystem.addComponent("ethane", 10.0, "kg/hr");
        testSystem.addComponent("propane", 4759.0, "kg/hr");
        testSystem.createDatabase(true);
        testSystem.setMixingRule(2);

        Stream stream_1 = new Stream("Stream1", testSystem);
        stream_1.setSpecification("bubT");

        ThrottlingValve JTvalve1 = new ThrottlingValve(stream_1);
        JTvalve1.setOutletPressure(3.0);
        
        Separator medPresSep = new Separator(JTvalve1.getOutStream());

        ThrottlingValve JTvalve2 = new ThrottlingValve(medPresSep.getLiquidOutStream());
        JTvalve2.setOutletPressure(1.11325);
        
        StreamInterface lowHStream = new Stream(JTvalve2.getOutStream());

        Cooler cooler2 = new Cooler(JTvalve2.getOutStream());
       // cooler2.setPressureDrop(0.35);
        cooler2.setSpecification("out stream");

        Stream stream_3 = new Stream(cooler2.getOutStream());
        stream_3.setSpecification("dewP");
        //stream_3.setTemperature(-40.0, "C");
        cooler2.setOutStream(stream_3);

        StreamInterface lowHStream2 = new Stream(stream_3);
        
        Compressor compressor1 = new Compressor(stream_3);
        compressor1.setOutletPressure(JTvalve1.getOutletPressure());

        Mixer propMixer = new Mixer();
        propMixer.addStream(compressor1.getOutStream());
        propMixer.addStream(medPresSep.getGasOutStream());
        
        Compressor compressor2 = new Compressor(propMixer.getOutStream());
        compressor2.setOutletPressure(stream_1.getPressure());
        
        Heater cooler3 = new Heater(compressor2.getOutStream());
        cooler3.setSpecification("out stream");
        cooler3.setOutStream(stream_1);

        neqsim.processSimulation.processSystem.ProcessSystem operations = new neqsim.processSimulation.processSystem.ProcessSystem();
        operations.add(stream_1);
        operations.add(JTvalve1);
        operations.add(medPresSep);
        
        operations.add(JTvalve2);
        
        operations.add(lowHStream);
        
        operations.add(cooler2);
        operations.add(stream_3);
        operations.add(lowHStream2);
        
        operations.add(compressor1);
        operations.add(propMixer);
        operations.add(compressor2);
        operations.add(cooler3);
      
        
        //     operations.add(compressor1);
        //    operations.add(heater);

        operations.run();
        operations.run();
        ThrottlingValve JTvalve3 = new ThrottlingValve(medPresSep.getLiquidOutStream());
        JTvalve3.setOutletPressure(2.03981146);
        JTvalve3.run();
        JTvalve3.getOutStream().displayResult();
       // JTvalve1.getOutStream().displayResult();
       //JTvalve2.getOutStream().displayResult();
       // medPresSep.displayResult();
       // stream_3.run();
       // stream_3.displayResult();
      // medPresSep.getLiquidOutStream().displayResult();
       // JTvalve2.getOutStream().displayResult();
        
        
    //    lowHStream.displayResult();
     //   lowHStream2.displayResult();
      //  medPresSep.displayResult();
      //  medPresSep.getLiquidOutStream().displayResult();
      //  stream_3.displayResult();
      //  compressor1.displayResult();
       // propMixer.getOutStream().displayResult();
      //  cooler2.getFluid().display();
      //  cooler2.run();
       // cooler3.displayResult();
        //   JTvalve.displayResult();
        //  compressor1.displayResult();
        //  stream_2.displayResult();
        // operations.displayResult();
        System.out.println("compressor1 work" + compressor1.getEnergy()/1.0e3 + " kW");
        System.out.println("compressor2 work" + compressor2.getEnergy()/1.0e3 + " kW");
        
        //   System.out.println("compressor isentropic ef " + compressor1.getIsentropicEfficiency());
        System.out.println("cooler2 mass flow " + cooler2.getOutStream().getFluid().getFlowRate("kg/hr") + " kg/hr");
        System.out.println("cooler3 mass flow " + cooler3.getOutStream().getFluid().getFlowRate("kg/hr") + " kg/hr");
        
        System.out.println("delta enthalpy " + (stream_3.getFluid().getEnthalpy()-JTvalve2.getOutStream().getFluid().getEnthalpy()));
        
        System.out.println("cooler2 duty " + cooler2.getEnergyInput()/1.0e3 + " kW");
        System.out.println("cooler3 duty " + cooler3.getEnergyInput()/1.0e3 + " kW");
        //  System.out.println("heater duty " + heater.getEnergyInput());

    }
}
