import java.io.FileNotFoundException;
import java.io.IOException;
import org.jdom2.JDOMException;

public class Run_exo4 {

	public static void main(String[] args) throws FileNotFoundException, IOException, JDOMException {
		
		WriteProductsXml products = new WriteProductsXml("./src/data/products.xml");
		
		// Ecriture du fichier
		products.write();
		
		// Lecture du fichier
		products.read();
		
	}

}
