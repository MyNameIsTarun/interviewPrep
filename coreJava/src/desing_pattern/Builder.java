package desing_pattern;

/*
 * The Builder design pattern is a creational pattern that separates the construction of a complex object from its representation, 
 * allowing the same construction process to create different representations. 
 * The primary goal is to construct a complex object step by step, 
 * providing a clear separation between the construction and the representation of the object.
 * The Builder design pattern is applied in situations where an object needs to be constructed with a large number of optional parameters or configurations, 
 * and creating multiple constructors with different parameter combinations becomes impractical.
 */
//Step 5: Client code
public class Builder {
	
	public static void main(String[] args) {
        ComputerDirector director = new Builder(). new ComputerDirector();

        // Build a standard computer
        ComputerBuilder standardBuilder = new Builder(). new StandardComputerBuilder();
        Computer standardComputer = director.buildComputer(standardBuilder);
        System.out.println("Standard Computer: " + standardComputer);

        // Build a gaming computer
        ComputerBuilder gamingBuilder = new Builder(). new GamingComputerBuilder();
        Computer gamingComputer = director.buildComputer(gamingBuilder);
        System.out.println("Gaming Computer: " + gamingComputer);
    }
	
	// Step 1: Product (Computer)
	@SuppressWarnings("unused")
	class Computer {
	    private String cpu;
	    private String memory;
	    private String storage;	    
		private String graphicsCard;

	    public Computer(String cpu, String memory, String storage, String graphicsCard) {
	        this.cpu = cpu;
	        this.memory = memory;
	        this.storage = storage;
	        this.graphicsCard = graphicsCard;
	    }

		public void setCpu(String cpu) {
			this.cpu = cpu;
		}

		public void setMemory(String memory) {
			this.memory = memory;
		}

		public void setStorage(String storage) {
			this.storage = storage;
		}

		public void setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
		}

	    // Getters for the attributes
	    // ...
	}

	// Step 2: Builder interface
	interface ComputerBuilder {
	    void buildCPU(String cpu);
	    void buildMemory(String memory);
	    void buildStorage(String storage);
	    void buildGraphicsCard(String graphicsCard);
	    Computer getResult();
	}

	// Step 3: ConcreteBuilder for Standard Computer
	class StandardComputerBuilder implements ComputerBuilder {
	    private Computer computer;

	    public StandardComputerBuilder() {
	        this.computer = new Computer("", "", "", "");
	    }

	    @Override
	    public void buildCPU(String cpu) {
	        computer.setCpu(cpu);
	    }

	    @Override
	    public void buildMemory(String memory) {
	        computer.setMemory(memory);
	    }

	    @Override
	    public void buildStorage(String storage) {
	        computer.setStorage(storage);
	    }

	    @Override
	    public void buildGraphicsCard(String graphicsCard) {
	        computer.setGraphicsCard(graphicsCard);
	    }

	    @Override
	    public Computer getResult() {
	        return computer;
	    }
	}


	// Step 3: ConcreteBuilder
	class GamingComputerBuilder implements ComputerBuilder {
	    private Computer computer;

	    public GamingComputerBuilder() {
	        this.computer = new Computer("High-end CPU", "16GB RAM", "1TB SSD", "Dedicated GPU");
	    }

	    @Override
	    public void buildCPU(String cpu) {
	        // Ignored for gaming computer
	    }

	    @Override
	    public void buildMemory(String memory) {
	        // Ignored for gaming computer
	    }

	    @Override
	    public void buildStorage(String storage) {
	        // Ignored for gaming computer
	    }

	    @Override
	    public void buildGraphicsCard(String graphicsCard) {
	        // Ignored for gaming computer
	    }

	    @Override
	    public Computer getResult() {
	        return computer;
	    }
	}

	// Step 4: Director
	class ComputerDirector {
	    public Computer buildComputer(ComputerBuilder builder) {
	        builder.buildCPU("Standard CPU");
	        builder.buildMemory("8GB RAM");
	        builder.buildStorage("500GB HDD");
	        builder.buildGraphicsCard("Integrated GPU");
	        return builder.getResult();
	    }
	}
	
	/*
	 * LocalDateTime dateTime = LocalDateTime.now()
                      .withYear(2023)
                      .withMonth(5)
                      .withDayOfMonth(15)
                      .withHour(12)
                      .withMinute(30);

	 */

}
