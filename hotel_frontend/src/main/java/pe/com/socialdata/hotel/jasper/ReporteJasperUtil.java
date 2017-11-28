package pe.com.socialdata.hotel.jasper;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReporteJasperUtil {

	static Log log = LogFactory.getLog(ReporteJasperUtil.class);
	
	
	public static ReporteArchivoBean generarArchivoPDF(ReporteJasperBean params, String rutaJasper, String rutaPdf){
		ReporteArchivoBean reportBean = new ReporteArchivoBean();
		JasperReport reporte;
		String path_jasper= rutaJasper + params.getJasperName();
		String path_pdf= rutaPdf + params.getFileName();
		
		InputStream inputStream = null;
		byte[] fileBytes ;
		try {
			log.debug(path_jasper);
			/*leer la plantilla jasper*/
			inputStream = new FileInputStream(path_jasper);
			log.debug("avilable: " + inputStream.available() );
			
			/*cargar la planilla jasper al report*/
			reporte = (JasperReport) JRLoader.loadObject(inputStream);
			log.debug("name jasper: " + reporte.getName());
			
			/*generar un datasource report con los fields*/
	        JRDataSource dsLista = new JRBeanCollectionDataSource(params.getListaDetalle());
	       
	        /*generar el reporte */
	        JasperPrint jasperPrint=new JasperPrint() ;
	        jasperPrint = JasperFillManager.fillReport( reporte,params.getParametros(), dsLista );
	       
	       
	        /*paginas del reporte*/
	        log.debug("pages: "+ jasperPrint.getPageWidth());
	      
	        /*generar el pdf */
	        fileBytes=JasperExportManager.exportReportToPdf(jasperPrint);
	    
	        /*
	        JRPdfExporter exporter = new JRPdfExporter();
		    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		    
		    SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();

		    configuration.setTagLanguage("en-us");
		    configuration.setMetadataAuthor("HOTEL");
		    	    
		    // Incluir tag para PDF/A-1a , para PDF/A-1b no es necesario
		    configuration.setTagged(true);
		    configuration.setPdfaConformance(PdfaConformanceEnum.PDFA_1B );  
			//configuration.setIccProfilePath(Constante.ICC_sRGB_IEC61966);
			configuration.setPdfVersion(PdfVersionEnum.VERSION_1_6);
			
		    log.debug("pages:1 ");
		    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		    log.debug("pages:2 ");
		    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(bOut));
		    log.debug("pages:3 ");
		    
		    exporter.exportReport();

		   fileBytes = bOut.toByteArray();
	       */
	        log.debug("size byte: "+fileBytes.length);
	        if(fileBytes.length > 0){
	        	FileOutputStream file = new FileOutputStream(path_pdf + ".pdf");
	        	file.write(fileBytes);
	        	reportBean.setData(fileBytes);
	        	reportBean.setFieldExtension("pdf");
	        	reportBean.setFieldName(path_pdf+".pdf");
	        	file.close();
	        }else{
	        	log.error("No se Genero El  Jasper y por lo tanto no el PDF");
	        }
	        
	        
	        inputStream.close();
		} catch (FileNotFoundException ex) {
			log.error("FileNotFoundException en ReporteJasperUtil.GenerarArchivoPDF: " + ex.getMessage(), ex);
			ex.printStackTrace();
		}catch (JRException ex) {
			log.error("JRException en ReporteJasperUtil.GenerarArchivoPDF: " + ex.getMessage(), ex);
			ex.printStackTrace();
		} catch (IOException ex) {
			log.error("IOException en ReporteJasperUtil.GenerarArchivoPDF: " + ex.getMessage(), ex);
			ex.printStackTrace();
		}
		return reportBean;
	}
	
	
	
	public static ReporteArchivoBean generarArchivoExcel(ReporteJasperBean params, String rutaJasper, String rutaPdf){
		ReporteArchivoBean reportBean = new ReporteArchivoBean();
		JasperReport reporte;
		String path_jasper= rutaJasper + params.getJasperName();
		String path_pdf= rutaPdf + params.getFileName();
		
		InputStream inputStream = null;
		byte[] fileBytes ;
		try {
			log.debug(path_jasper);
			/*leer la plantilla jasper*/
			inputStream = new FileInputStream(path_jasper);
			log.debug("avilable: " + inputStream.available() );
			
			/*cargar la planilla jasper al report*/
			reporte = (JasperReport) JRLoader.loadObject(inputStream);
			log.debug("name jasper: " + reporte.getName());
			
			/*generar un datasource report con los fields*/
	        JRDataSource dsLista = new JRBeanCollectionDataSource(params.getListaDetalle());
	       
	        /*generar el reporte */
	        JasperPrint jasperPrint=new JasperPrint() ;
	        jasperPrint = JasperFillManager.fillReport( reporte,params.getParametros(), dsLista );
	       
	       
	        /*paginas del reporte*/
	        log.debug("pages: "+ jasperPrint.getPageWidth());
	      
	        /*generar el Excel */
	       // fileBytes=JasperExportManager.exportReportToPdf(jasperPrint);
	        //fileBytes=JasperExportManager.exportReport(jasperPrint);
	    
	        ByteArrayOutputStream output = new ByteArrayOutputStream();
	        JRXlsExporter exporterXls = new JRXlsExporter();
            exporterXls.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporterXls.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
            exporterXls.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            exporterXls.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            exporterXls.exportReport();
            
            fileBytes =output.toByteArray();
            //outputfile.write(output.toByteArray());
          
	        log.debug("size byte: "+fileBytes.length);
	        if(fileBytes.length > 0){
	        	FileOutputStream file = new FileOutputStream(path_pdf + ".xls");
	        	file.write(fileBytes);
	        	reportBean.setData(fileBytes);
	        	reportBean.setFieldExtension("xls");
	        	reportBean.setFieldName(path_pdf+".xls");
	        	file.close();
	        }else{
	        	log.error("No se Genero El  Jasper y por lo tanto no el XLS");
	        }
	        
	        
	        inputStream.close();
		} catch (FileNotFoundException ex) {
			log.error("FileNotFoundException en ReporteJasperUtil.GenerarArchivoXLS: " + ex.getMessage(), ex);
			ex.printStackTrace();
		}catch (JRException ex) {
			log.error("JRException en ReporteJasperUtil.GenerarArchivoXLS: " + ex.getMessage(), ex);
			ex.printStackTrace();
		} catch (IOException ex) {
			log.error("IOException en ReporteJasperUtil.GenerarArchivoXLS: " + ex.getMessage(), ex);
			ex.printStackTrace();
		}
		return reportBean;
	}
}
