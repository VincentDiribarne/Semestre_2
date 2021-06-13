import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.util.IteratorIterable;

public class WriteProductsXml {

	private String filename;

	public WriteProductsXml(String filename) {
		super();
		this.filename = filename;
	}

	public void write() throws FileNotFoundException, IOException {

		List<Coffee> coffees = new ArrayList<>();
		coffees.add(new Coffee("001", "Robusta",3.15));
		coffees.add(new Coffee("002", "Noir Désir",2.21));
		coffees.add(new Coffee("003", "Java",5.15));

		Element cafes = new Element("cafes");
		Document doc = new Document(cafes);
		// doc.setRootElement(cafes);

		for (Coffee coffee : coffees) {
			Element cafe = new Element("cafe");
			cafe.setAttribute(new Attribute("id", coffee.id));
			cafe.addContent(new Element("nom").setText(coffee.name));
			cafe.addContent(new Element("prix").setText(coffee.price + ""));

			doc.getRootElement().addContent(cafe);
			
		}
		
		// Write console for Debug
		new XMLOutputter().output(doc, System.out);
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter(this.filename));

		System.out.println("File Saved!");
	}

	public void read() throws JDOMException, IOException {

		// 1. Creation d'un parser SAX
		SAXBuilder saxBuilder = new SAXBuilder();

		// 1. Creation d'un document JDOM
		Document document = saxBuilder.build(this.filename);

		IteratorIterable<?> processDescendants = document.getDescendants(new ElementFilter("cafe"));

		while (processDescendants.hasNext()) {
			org.jdom2.Element elt = (org.jdom2.Element) processDescendants.next();
			Coffee coffee = new Coffee(elt.getAttributeValue("id"), elt.getChild("nom").getTextTrim(), Double.parseDouble(elt.getChild("prix").getTextTrim()));
			System.out.println(coffee);
		}
	}

}
