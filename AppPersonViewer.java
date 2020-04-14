import java.text.Collator;
import java.util.Locale;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class AppPersonViewer extends TableViewer {
	public AppPersonViewer(Composite composite, int style) {
		super(composite, style);
		Table table = getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gridData);
		createColumns();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		setContentProvider(new AppContentProvider());
	}

	public static final String[] columnTitles = {"String", "String", "Integer"};
	
	private void createColumns() {
//		String[] titles = {"String", "String", "Integer"};
		int[] bounds = {150, 150, 100};
		TableViewerColumn column = createTableViewerColumn(columnTitles[0], bounds[0], 0);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ((Data)element).getFirst();
				return super.getText(element);
			}
		});
		column.setEditingSupport(new OptionEditingSupport(this, 0));
//	    column.addListener(SWT.Selection, new Listener() {
//	        public void handleEvent(Event e) {
//	          // sort column 1
//	          TableItem[] items = getTable().getItems();
//	          Collator collator = Collator.getInstance(Locale.getDefault());
//	          for (int i = 1; i < items.length; i++) {
//	            String value1 = items[i].getText(0);
//	            for (int j = 0; j < i; j++) {
//	              String value2 = items[j].getText(0);
//	              if (collator.compare(value1, value2) < 0) {
//	                String[] values = { items[i].getText(0),
//	                    items[i].getText(1) };
//	                items[i].dispose();
//	                TableItem item = new TableItem(getTable(), SWT.NONE, j);
//	                item.setText(values);
//	                items = getTable().getItems();
//	                break;
//	              }
//	            }
//	          }
//	        }
//	      });
		
		column = createTableViewerColumn(columnTitles[1], bounds[1], 1);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ((Data)element).getSecond();
				return super.getText(element);
			}
		});
		column.setEditingSupport(new OptionEditingSupport(this, 1));
		
		column = createTableViewerColumn(columnTitles[2], bounds[2], 2);
		column.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				if(element instanceof Data) return ""+((Data)element).getThird();
				return super.getText(element);
			}
		});
		column.setEditingSupport(new OptionEditingSupport(this, 2));
	}
	
	private TableViewerColumn createTableViewerColumn(String header, int width, int index) {
		TableViewerColumn column = new TableViewerColumn(this, SWT.LEFT, index);
		column.getColumn().setText(header);
		column.getColumn().setWidth(width);
		column.getColumn().setResizable(true);
		column.getColumn().setMoveable(true);
		return column;
	}
}
