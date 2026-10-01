import java.awt.*;
import javax.swing.*;

class VehicleModel {

    int calculateCost(boolean general, boolean oil,
                      boolean brake, boolean battery) {

        int cost = 0;

        if (general)
            cost += 1000;

        if (oil)
            cost += 800;

        if (brake)
            cost += 1200;

        if (battery)
            cost += 500;

        return cost;
    }
}

// VIEW
class VehicleView extends JFrame {

    JTextField regNo = new JTextField();

    JRadioButton twoWheeler =
        new JRadioButton("Two Wheeler");

    JRadioButton car =
        new JRadioButton("Car");

    JCheckBox general =
        new JCheckBox("General Service - ₹1000");

    JCheckBox oil =
        new JCheckBox("Oil Change - ₹800");

    JCheckBox brake =
        new JCheckBox("Brake Service - ₹1200");

    JCheckBox battery =
        new JCheckBox("Battery Check - ₹500");

    JButton calculate =
        new JButton("Calculate Cost");

    JLabel result =
        new JLabel("Total Cost: ₹0");

    VehicleView() {

        setTitle("Vehicle Service Cost");
        setSize(450, 400);
        setLayout(new GridLayout(9, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Vehicle Registration Number"));
        add(regNo);

        ButtonGroup group = new ButtonGroup();
        group.add(twoWheeler);
        group.add(car);

        add(twoWheeler);
        add(car);

        add(general);
        add(oil);
        add(brake);
        add(battery);

        add(calculate);
        add(result);

        setVisible(true);
    }
}

// CONTROLLER
class VehicleController {

    VehicleModel model;
    VehicleView view;

    VehicleController(VehicleModel model, VehicleView view) {

        this.model = model;
        this.view = view;

        view.calculate.addActionListener(e -> calculate());
    }

    void calculate() {

        int cost = model.calculateCost(
            view.general.isSelected(),
            view.oil.isSelected(),
            view.brake.isSelected(),
            view.battery.isSelected()
        );

        view.result.setText("Total Cost: ₹" + cost);
    }
}

// MAIN
public class VehicleService {

    public static void main(String[] args) {

        VehicleModel model = new VehicleModel();
        VehicleView view = new VehicleView();

        new VehicleController(model, view);
    }
}