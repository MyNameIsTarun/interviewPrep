package solid;

/*
 * Single Responsibility Principle
 * A class should have only one reason to change, meaning that it should have only one responsibility or job.
 */
public class SRP {

	// Before
	class Report {
	    void generate() {
	        // logic for generating the report
	    }
	    void saveToFile() {
	        // logic for saving the report to a file
	    }
	}

	// After
	class ReportGenerator {
	    void generate() {
	        // logic for generating the report
	    }
	}

	class ReportSaver {
	    void saveToFile() {
	        // logic for saving the report to a file
	    }
	}

}
