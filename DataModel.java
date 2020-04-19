import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Shell;

public class DataModel {
    protected static Shell shell;
    private List<Data> persons = new ArrayList<Data>();
    
    public DataModel(int samples) {
        for(int i = 0; i < samples; i++) {
        	persons.add(new Data(Data.FIRST[i], Data.SECOND[i], Data.THIRD[i]));
        }
    }

    List<Data> getData() {
        return persons;
    }
}
