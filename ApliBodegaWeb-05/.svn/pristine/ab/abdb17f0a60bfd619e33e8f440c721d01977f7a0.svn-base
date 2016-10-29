package Country;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportTestController {

    private static final Logger log = LoggerFactory.getLogger(ReportTestController.class);

    private StreamedContent media;
    private ByteArrayOutputStream outputStream;
    private String number;

    public void generateReport() {
        try {
            List<Country> countries = getListCountriesDummy();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("fecha", Calendar.getInstance().getTime().toString());

            outputStream = JasperReportUtil.getOutputStreamFromReport(countries, map, getPathFileJasper());
            media = JasperReportUtil.getStreamContentFromOutputStream(outputStream, "application/pdf", getNameFilePdf());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public String getPathFileJasper() {
//        return getFullPathResource("/report/paises.jasper");
    	return null;
    }

    public String getNameFilePdf() {
        return "reporte_dummy.pdf";
    }

    public void downloadFile() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            response.reset();
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "attachment; filename=" + getNameFilePdf());
            
            OutputStream output = response.getOutputStream();
            output.write(outputStream.toByteArray());
            output.close();
            
            facesContext.responseComplete();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
    
    private List<Country> getListCountriesDummy() {
        List<Country> countries = new ArrayList<Country>();
        int max = Integer.parseInt(number);
        for (int i = 1; i <= max; i++) {
            countries.add(new Country("ID" + i, "Pais " + i));
        }
        return countries;
    }

 public StreamedContent getMedia() {
        return media;
    }

    public void setMedia(StreamedContent media) {
        this.media = media;
    }
 
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
