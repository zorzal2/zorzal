package com.fontar.adjunto;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.struts.upload.FormFile;

import com.fontar.bus.api.varios.AdjuntoServicio;
import com.fontar.bus.impl.domain.junit.ServiceBaseTest;
import com.fontar.data.impl.domain.dto.AdjuntoContenidoDTO;
import com.fontar.data.impl.domain.dto.AdjuntoDTO;

public class AdjuntoTest extends ServiceBaseTest {

	public void testList() throws Exception {
		AdjuntoServicio adjuntoServicio = (AdjuntoServicio) getBean("adjuntoServicio");
		//List lista = (List) adjuntoServicio.getAdjuntos();
		//lista.isEmpty();
	}	
	
	public void _testCreate() throws FileNotFoundException, IOException{
		AdjuntoServicio adjuntoServicio = (AdjuntoServicio) getBean("adjuntoServicio");
		//AdjuntoContenidoServicio adjuntoContenidoServicio = (AdjuntoContenidoServicio) getBean("adjuntoContenidoServicio");

		AdjuntoDTO adjuntoDTO = new AdjuntoDTO();
		AdjuntoContenidoDTO adjuntoContenidoDTO = new AdjuntoContenidoDTO();

		//construyo el dto
		
	    InputStream in = null;
	    ByteArrayOutputStream out = null;
		FileInputStream fileInputStream = new FileInputStream("C:/matias/matias.txt");
		FormFile file = (FormFile) fileInputStream;
		InputStream filee = fileInputStream;
		try{
		    //in = content.getInputStream();
		    in = file.getInputStream();
		    // Create an output stream to a file
		    out = new ByteArrayOutputStream();
		    byte[] buffer = new byte[512];
		    while (in.read(buffer) != -1) {
		      out.write(buffer);
		    }
		} catch (FileNotFoundException exeption) {
			exeption.printStackTrace();
		} catch (IOException exeption) {
			exeption.printStackTrace();
		} finally {
			try {
				if (out != null) out.close();
				if (in != null) in.close();
			} catch(IOException exception) {
				exception.printStackTrace();
			}
	    }  
	    adjuntoDTO.setCantidadLongitud(new Long(file.getFileSize()));
	    adjuntoDTO.setNombre(file.getFileName());
	    adjuntoDTO.setTipoContenido(file.getContentType());
	    adjuntoDTO.setFecha(new Date());
	    adjuntoDTO.setDescripcion("matias");
	    
	    //adjuntoContenidoDTO.setBlArchivo(out.toString());
		//adjuntoServicio.create(adjuntoDTO,adjuntoContenidoDTO);

	}
}
