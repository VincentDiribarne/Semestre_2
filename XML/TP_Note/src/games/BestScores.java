package games;

import com.google.gson.Gson;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.util.IteratorIterable;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BestScores {

    private int max_scores;
    public static int DEFAULT_MAX_SCORES = 10;
    Score[] scores;
    int nb_scores = 0;
    private E_ORDER_BY order_by;

    public static enum E_ORDER_BY {
        ASC, DESC
    }

    public BestScores() {
        super();
    }

    public BestScores(E_ORDER_BY order_by) {
        this(order_by, BestScores.DEFAULT_MAX_SCORES);
    }

    public BestScores(E_ORDER_BY order_by, int max_scores) {
        super();
        this.order_by = order_by;
        this.max_scores = max_scores;
        this.scores = new Score[this.max_scores];
        this.nb_scores = 0;
    }

    // Compare deux scores A et B
    private boolean is_better(int valueA, int valueB) {
        if (this.order_by == BestScores.E_ORDER_BY.ASC && valueA < valueB) {
            return true;
        }
        if (this.order_by == BestScores.E_ORDER_BY.DESC && valueA > valueB) {
            return true;
        }
        return false;
    }

    // Position du score dans la liste
    //      score : valeur du score
    private int get_position(int new_score) {
        for (int i = 0; i < this.nb_scores; i++) {
            Score score = this.scores[i];
            if (this.is_better(new_score, score.value)) {
                return i;
            }
        }
        return this.nb_scores;
    }

    // Définit si un score fait partie des meilleurs scores
    //      score : valeur du score
    public boolean is_scoring(int new_score) {
        return this.nb_scores < this.max_scores || this.is_better(new_score, this.scores[this.nb_scores - 1].value);
    }

    // Ajout d'un score
    //    value : combien ?
    //    who : qui ?
    //    when : quand ?
    public void add_score(int value, String who, String when) {
        int pos = this.get_position(value);
        for (int i = this.max_scores - 1; i > pos; i--) {
            this.scores[i] = this.scores[i - 1];
        }
        if (pos < this.max_scores) {
            this.scores[pos] = new Score(value, who, when);
            if (this.nb_scores < this.max_scores)
                this.nb_scores++;
        }
    }

    // Ajout d'un score
    //    value : combien ?
    //    who : qui ?
    public void add_score(int value, String who) {
        this.add_score(value, who, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
    }

    // Ajout d'un score à partir d'un objet Score
    //     filename : nom du fichier
    public void add_score(Score score) {
        this.add_score(score.value, score.who, score.when);
    }

    // Conversion String pour affichage
    public String toString() {
        String s = "";
        for (int i = 0; i < this.nb_scores; i++) {
            Score score = this.scores[i];
            s += (i + 1) + " - " + score.value + ", " + score.who + ", " + score.when + "\n";
        }
        return s;
    }

    // Affichage des scores sur console
    public void write() {
        for (int i = 0; i < this.nb_scores; i++) {
            Score score = this.scores[i];
            System.out.println((i + 1) + " - " + score.value + ", " + score.who + ", " + score.when);
        }
    }

    public void load_xml(String filename) throws IOException, JDOMException {
        if (file_exists(filename)) {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(filename);
            IteratorIterable<?> processDescendants = document.getDescendants(new ElementFilter("score"));
            while (processDescendants.hasNext()) {
                org.jdom2.Element elt = (org.jdom2.Element) processDescendants.next();
                if (elt.getChild("valeur") != null) {
                    Score scores = new Score(Integer.parseInt(elt.getChild("valeur").getTextTrim()), elt.getChild("name").getTextTrim(), elt.getChild("date").getTextTrim());
                    System.out.println("Nom : " +scores.who+ ", Score : " +scores.value+ ", Date : " +scores.when);
                }
            }
        }
    }

    public void save_xml(String filename) throws IOException {
        Element scores = new Element("scores");
        Document doc = new Document(scores);

        for (Score score : this.scores) {
            if (score != null) {
                Element scoreParam = new Element("Score");
                scoreParam.addContent(new Element("valeur").setText("" + score.value));
                scoreParam.addContent(new Element("nom").setText(score.who));
                scoreParam.addContent(new Element("date").setText(score.when));

                doc.getRootElement().addContent(scoreParam);
            }
        }

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileWriter(filename));
    }

    public void load_json(String filename) throws Exception {
        Gson g = new Gson();
        scores = g.fromJson(new FileReader(filename), Score[].class);
        for (Score score: scores) {
            if (score != null) {
                System.out.println("Nom : " +score.who+ ", Score : " +score.value+ ", Date : " +score.when);
            }
        }
    }

    public void save_json(String filename) throws IOException {
        for (Score score : scores) {
            if (score != null) {
                score.toString();
            }
        }
        Gson g = new Gson();
        FileWriter f = new FileWriter(filename);
        g.toJson(scores, f);
        f.flush();
        f.close();
        System.out.println("Votre score a ete enregistre !");
    }

    // Teste l'existence d'un fichier
    // filename : nom du fichier
    static public Boolean file_exists(String filename) {
        File f = new File(filename);
        if (f.exists() && !f.isDirectory())
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {
        /* Unit tests */

        // Init d'un BestScores de 5 scores, dans l'ordre croissant
        BestScores best_scores = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
        // Ajout d'un score
        best_scores.add_score(12, "A");
        // Ajout d'un score
        best_scores.add_score(15, "B");

        // Catégorie test de is_scoring
        System.out.println("===== Test de scoring =====");

        // Teste si un score peut rentrer dans les meilleurs scores
        System.out.println(best_scores.is_scoring(16));
        System.out.println(best_scores.is_scoring(14));
        System.out.println(best_scores.is_scoring(11));
        // Ajout de scores
        best_scores.add_score(21, "C");
        best_scores.add_score(14, "D");
        best_scores.add_score(33, "E");
        best_scores.add_score(37, "F");
        best_scores.add_score(30, "G");
        best_scores.add_score(7, "H");
        best_scores.add_score(21, "I");
        best_scores.add_score(33, "J");
        best_scores.add_score(5, "K");
        // Teste si un score peut rentrer dans les meilleurs scores
        System.out.println(best_scores.is_scoring(100));
        System.out.println(best_scores.is_scoring(11));

        // Catégorie Affichage
        System.out.println("\n===== Affichage normal =====");

        // Affichage(s)
        System.out.println("\n----- BestScores.write() -----");
        best_scores.write();
        System.out.println("\n----- Sys Out -----");
        System.out.println(best_scores);

        // Catégorie XML
        System.out.println("\n===== XML =====");

        // Sauvegarde XML
        try {
            best_scores.save_xml("data/scores.xml");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Chargement XML
        try {
            System.out.println("\n----- Load XML -----");
            best_scores.load_xml("data/scores.xml");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("\n----- Write -----");
        best_scores.write();

        // Catégorie JSON
        System.out.println("\n===== JSON =====");

        // Sauvegarde JSON (non implémenté)
        try {
            best_scores.save_json("data/scores.json");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        best_scores.add_score(5, "M");
        System.out.println("\n----- Write -----");
        best_scores.write();

        // Chargement JSON (non implémenté)
        System.out.println("\n----- Load JSON -----");
        best_scores.load_json("data/scores.json");
    }
}
