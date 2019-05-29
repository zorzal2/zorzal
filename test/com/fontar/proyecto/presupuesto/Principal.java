

package com.fontar.proyecto.presupuesto;

import java.io.File;
import java.util.Collection;

import jxl.Workbook;

import com.fontar.data.impl.domain.bean.ProyectoPresupuestoBean;
import com.fontar.data.impl.domain.bean.proyecto.presupuesto.rubros.PresupuestoRubroBean;
import com.fontar.data.impl.domain.bean.proyecto.presupuesto.rubros.PresupuestoRubroCollectionBean;
import com.fontar.proyecto.presupuesto.excel.parser.FormularioANRParser;
import com.fontar.proyecto.presupuesto.xml.reader.PresupuestoXMLReader;
import com.fontar.proyecto.presupuesto.xml.writer.PresupuestoXMLSerializer;

/**
 * Main para prubas sin JUnit.
 * @author llobeto
 *
 */
public class Principal {

	private static String EXCEL_FILE = "C:\\Proyecto\\ExcelParser\\prototipo2.xls";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Workbook workbook = Workbook.getWorkbook(new File(EXCEL_FILE));

			FormularioANRParser parser = new FormularioANRParser();
			ProyectoPresupuestoBean presupuesto = parser.parse(workbook);
			System.out.println(presupuesto);
			
			Collection<PresupuestoRubroBean> presupuestoRubroCollectionBean = presupuesto.getPresupuestoRubros();
			String xml1 = PresupuestoXMLSerializer.instance.serialize((PresupuestoRubroCollectionBean) presupuestoRubroCollectionBean);
			System.out.println(xml1);
			presupuestoRubroCollectionBean = PresupuestoXMLReader.instance.unserialize(xml1);
			String xml2 = PresupuestoXMLSerializer.instance.serialize((PresupuestoRubroCollectionBean) presupuestoRubroCollectionBean);
			System.out.println(xml2);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 

	}

}
