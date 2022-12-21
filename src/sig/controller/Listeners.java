
package sig.controller;
    
import sig.model.invoiceHeader;
import sig.model.invoiceLine;
import sig.model.LinesTable;
import sig.view.invoiceFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Listeners implements ListSelectionListener {

    private  invoiceFrame _TheInvoiceFrame;

    public Listeners(invoiceFrame frame) {
        this._TheInvoiceFrame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = _TheInvoiceFrame.getheaderTable().getSelectedRow();
        System.out.println("Invoice selected: " + selectedInvIndex);
        if (selectedInvIndex != -1) {
            invoiceHeader selectedInv = _TheInvoiceFrame.getInvoicesArray().get(selectedInvIndex);
            ArrayList<invoiceLine> lines = selectedInv.getLines();
            LinesTable lineTable = new LinesTable(lines);
            _TheInvoiceFrame.setLinesArray(lines);
            _TheInvoiceFrame.getlineTable().setModel(lineTable);
            _TheInvoiceFrame.getCustNameLbl().setText(selectedInv.getCustomer());
            _TheInvoiceFrame.getInvNumLbl().setText("" + selectedInv.getNum());
            _TheInvoiceFrame.getInvTotalIbl().setText("" + selectedInv.getItemTotal());
            _TheInvoiceFrame.getDateLbl().setText(invoiceFrame.dateFormat.format(selectedInv.getDate()));
        }
    }

}

    

