import java.util.ArrayList;
import java.util.List;

public class DataModel {
    private int samples;
    public DataModel(int samples) {
        this.samples = samples;
    }

    List<Data> getData()
    {
        List<Data> persons = new ArrayList<Data>();
        for(int i=0; i<samples; i++)
            persons.add(Data.createRandomData());
        return persons;
    }
}
