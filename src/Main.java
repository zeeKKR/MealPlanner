import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zook on 12/26/15.
 */
public class Main {
    public static void main(String[] args) {
        //List<Recipe> cookbook = createCookbook();
        //List<Ingredient> pantry = new ArrayList<>();
        //pantry.add(new Ingredient(10, Unit.CUP_OF, "milk"));
        PDFParser parser = null;
        try {
            parser = new PDFParser(
                    new RandomAccessBufferedFileInputStream("/Users/zook/Documents/Italian-Meatball-Soup.pdf"));
            parser.parse();
            COSDocument doc = parser.getDocument();
            PDFTextStripperByArea pdfStripper = new PDFTextStripperByArea();
            PDDocument pdDoc = new PDDocument(doc);
            PDPage page = pdDoc.getPage(0);
            System.out.println(page.getMediaBox().getHeight());
            System.out.println(page.getMediaBox().getWidth());
            pdfStripper.addRegion("Ingredients", new Rectangle2D.Double(0, 400, 612, 392));
            pdfStripper.extractRegions(page);
            System.out.println(pdfStripper.getTextForRegion("Ingredients"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //getAllValidRecipes(cookbook, pantry);
    }

    public static List<Recipe> createCookbook() {
        List<Recipe> cookbook = new ArrayList<>();
        Recipe r = new Recipe("foo");
        r.addIngredient(10, Unit.CUP_OF, "milk");
        cookbook.add(r);
        return cookbook;
    }

//    public static List<Recipe> getAllValidRecipes(List<Recipe> cookbook, List<Ingredient> pantry) {
//        for (Recipe r : cookbook) {
//            for (Ingredient i : r.getIngredients()) {
//
//            }
//        }
//    }
}
