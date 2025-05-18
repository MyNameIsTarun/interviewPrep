package solid;

/*
 * Dependency Inversion Principle
 * High-level modules should not depend on low-level modules. Both should depend on abstractions. 
 * Abstractions should not depend on details; details should depend on abstractions.
 * DIP tells us that every dependency in the design should target an interface or an abstract class. 
 * Furthermore, a dependency should not target a concrete class.
 * 
 * Promotes loosely coupled softwares
 */
public class DIP {
	
	// Before
	class LightBulb {
	    void turnOn() {
	        // logic for turning on the light bulb
	    }

	    void turnOff() {
	        // logic for turning off the light bulb
	    }

		public boolean isOn() {
			return true;
		}
	}

	class Switch {
	    LightBulb bulb;

	    Switch(LightBulb bulb) {
	        this.bulb = bulb;
	    }

	    void operate() {
	        if (bulb.isOn()) {
	            bulb.turnOff();
	        } else {
	            bulb.turnOn();
	        }
	    }
	}
	
	// ---------------------------------------------------------------------------------------------------------

	// After
	interface Switchable {
	    void turnOn();

	    void turnOff();

		boolean isOn();
	}

	class LightBulb1 implements Switchable {
	    @Override
	    public void turnOn() {
	        // logic for turning on the light bulb
	    }

	    @Override
	    public void turnOff() {
	        // logic for turning off the light bulb
	    }

		@Override
		public boolean isOn() {
			return true;
		}
	}

	class Switch1 {
	    Switchable device;

	    Switch1(Switchable device) {
	        this.device = device;
	    }

	    void operate() {
	        if (device.isOn()) {
	            device.turnOff();
	        } else {
	            device.turnOn();
	        }
	    }
	}

}
