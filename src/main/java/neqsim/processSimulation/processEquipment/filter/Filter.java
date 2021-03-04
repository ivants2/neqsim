package neqsim.processSimulation.processEquipment.filter;

import neqsim.processSimulation.processEquipment.ProcessEquipmentBaseClass;
import neqsim.processSimulation.processEquipment.ProcessEquipmentInterface;
import neqsim.processSimulation.processEquipment.stream.Stream;
import neqsim.processSimulation.processEquipment.stream.StreamInterface;
import neqsim.thermo.system.SystemInterface;
import neqsim.thermodynamicOperations.ThermodynamicOperations;

public class Filter extends ProcessEquipmentBaseClass {
	
	private double deltaP = 0.01;
    protected StreamInterface outStream;
    protected StreamInterface inStream;
    private double pressureCoef= 0.0;
    
    public Filter(StreamInterface inStream) {
        this.inStream = inStream;
        outStream = (Stream) inStream.clone();
    }
    
	public void run() {
			SystemInterface system = (SystemInterface) inStream.getThermoSystem().clone();
			if(Math.abs(getDeltaP())>1e-10) {
	        system.setPressure(inStream.getPressure()-getDeltaP());
	        ThermodynamicOperations testOps = new ThermodynamicOperations(system);
	        testOps.TPflash();
			}
			system.initProperties();
	        outStream.setThermoSystem(system);
	}

	public double getDeltaP() {
		return deltaP;
	}

	public void setDeltaP(double deltaP) {
		this.deltaP = deltaP;
	}
	
	   public StreamInterface getOutStream() {
	        return outStream;
	    }
	   
		public void runConditionAnalysis(ProcessEquipmentInterface refTEGabsorberloc) {
			double deltaP = inStream.getPressure("bar")-outStream.getPressure("bar");
			pressureCoef = deltaP/inStream.getFlowRate("kg/hr");
		}

		double getPressureCoef() {
			return pressureCoef;
		}

		void setPressureCoef(double pressureCoef) {
			this.pressureCoef = pressureCoef;
		}
}