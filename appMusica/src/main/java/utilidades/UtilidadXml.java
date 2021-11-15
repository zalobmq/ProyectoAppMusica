package utilidades;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import modelos.DatosDeConexion;

public class UtilidadXml {

	public static void marshal(String path, DatosDeConexion dc) {
        JAXBContext jaxbC;
        try {
            jaxbC = JAXBContext.newInstance(DatosDeConexion.class);
            Marshaller m = jaxbC.createMarshaller();
            m.setProperty(m.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(dc, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static DatosDeConexion unmarshal(String path) {
    	DatosDeConexion result;
        JAXBContext jaxbC;
        File file = new File(path);
        if (file.exists() && file.isFile() && path != null && !path.isEmpty()) {
            try {
                jaxbC = JAXBContext.newInstance(DatosDeConexion.class);
                Unmarshaller um = jaxbC.createUnmarshaller();
                result = (DatosDeConexion) um.unmarshal(new File(path));
            } catch (JAXBException e) {
                result = new DatosDeConexion("localhost", "app_musica2", "root", "");
             System.out.println("ERROR LEYENDO EL XML. SE HA ESTABLEIDO UN CONEXION POR DEFECTO");
            }
        } else {
        	System.out.println("NO EXISTE EL FICHERO XML. SE CREARA UNO CON LOS DATOS POR DEFECTO");
            DatosDeConexion dc = new DatosDeConexion("localhost", "app_musica2", "root", "");
            marshal(path, dc);
            result = dc;
        }
        return result;
    }
}
