import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.getProcessButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startProcessing();
            }
        });
    }


    private void startProcessing() {
        view.getProcessButton().setEnabled(false);
        view.getStatusLabel().setText("Processing data...");
        view.getOutputArea().setText("");

        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

             @Override
             protected Void doInBackground() throws Exception {
                 model.generateAndProcessData(100, new Model.ProgressListener() {
                     @Override
                     public void progress(int current, int total) {
                         publish((current * 100) / total);
                     }
                 });

                 return null;
             }


            @Override
            protected void process(List<Integer> chunks) {
                if (!chunks.isEmpty()) {
                    int latestProgress = chunks.get(chunks.size() - 1);
                    view.getProgressBar().setValue(latestProgress);
                }
            }


             @Override
            protected void done() {

                List<String> data = model.getData();

                 for(String d : data){
                    view.updateOutputArea(d);
                 }

                 view.getStatusLabel().setText("Data processing completed.");
                view.getProcessButton().setEnabled(true);
            }
        };

        worker.execute();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                View view = new View();
                new Controller(model, view);
            }
        });
    }
}