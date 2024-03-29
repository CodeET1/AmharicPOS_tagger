import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

public class AmharicPOSTagger2 {
    public static void main(String[] args) throws Exception {
        String amharicText = "አማርኛ ጽሑፍ ለ POS መለያ";

        POSModel model = new POSModelLoader().load(new File("path/to/amharic-pos-model"));
        POSTaggerME tagger = new POSTaggerME(model);

        String[] tokens = WhitespaceTokenizer.INSTANCE.tokenize(amharicText);
        String[] tags = tagger.tag(tokens);

        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i] + " - " + tags[i]);
        }
    }
}
