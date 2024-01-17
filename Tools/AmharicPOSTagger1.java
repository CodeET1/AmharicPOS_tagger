import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

import java.io.FileInputStream;
import java.io.InputStream;

public class AmharicPOSTagger2 {
    public static void main(String[] args) {
        try {
            // Load the POS model
            InputStream modelIn = new FileInputStream("path/to/your/en-pos-maxent.bin");
            POSModel model = new POSModel(modelIn);
            POSTaggerME tagger = new POSTaggerME(model);

            // Example sentence to be tagged
            String sentence = "እኔ የአማርኛ ቋንቋ ነኝ";

            // Tokenize the sentence
            String[] tokens = WhitespaceTokenizer.INSTANCE.tokenize(sentence);

            // Perform POS tagging
            String[] tags = tagger.tag(tokens);

            // Print the tokens and their POS tags
            for (int i = 0; i < tokens.length; i++) {
                System.out.println(tokens[i] + " : " + tags[i]);
            }

            // Clean up
            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
