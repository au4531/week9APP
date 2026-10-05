class EmergencyAlert extends Thread {

    public EmergencyAlert() {
        setName("EmergencyAlert");
        setPriority(Thread.MAX_PRIORITY);   // 10
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Critical patient alert");
        }
    }
}

class VitalMonitor extends Thread {

    public VitalMonitor() {
        setName("VitalMonitor");
        setPriority(Thread.NORM_PRIORITY);  // 5
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Checking vital signs");
        }
    }
}

class ReportGenerator extends Thread {

    public ReportGenerator() {
        setName("ReportGenerator");
        setPriority(Thread.MIN_PRIORITY);   // 1
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " | Priority: "
                    + getPriority() + " | Generating report");
        }
    }
}

public class HospitalMonitoring {
    public static void main(String[] args) {

        EmergencyAlert emergency = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        emergency.start();
        vital.start();
        report.start();
    }
}