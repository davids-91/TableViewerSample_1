import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Shell;

public class DataModel {
    private int samples;
    protected static Shell shell;
    public DataModel(int samples) {
        this.samples = samples;
    }

    List<Data> getData() {
        List<Data> persons = new ArrayList<Data>();
        for(int i = 0; i < samples; i++)
//            persons.add(Data.createRandomData());
        	persons.add(new Data(Data.FIRST[i], Data.SECOND[i], Data.THIRD[i]));
        return persons;
    }
}
