import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<String> data;

    public Model() {
        this.data = new ArrayList<>();
    }

    public List<String> getData() {
        return data;
    }

    public void generateAndProcessData(int count, ProgressListener progressListener) throws InterruptedException {
        data.clear();
        for (int i = 0; i < count; i++) {
            String item = "Item-" + (i + 1);
            data.add(item);

            // Simulasi pemrosesan yang memakan waktu
            Thread.sleep(50);

            // Perbarui progress
            if (progressListener != null) {
                progressListener.progress(i + 1, count);
            }
        }

        System.out.println("Proses data berhasil.");
    }

    public interface ProgressListener {
        void progress(int current, int total);
    }
}