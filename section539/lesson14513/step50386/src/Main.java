/**
 * Допустим, мы будем фильтровать спам, комментарии с негативным содержанием и слишком длинные комментарии.
 * Спам будем фильтровать по наличию указанных ключевых слов в тексте.
 * Негативное содержание будем определять по наличию одного из трех смайликов – :( =( :|
 * Слишком длинные комментарии будем определять исходя из данного числа – максимальной длины комментария.
 */
class Main {
    //Stepik code: start

    abstract class KeywordAnalyzer implements TextAnalyzer {
        protected abstract String[] getKeywords();
        protected abstract Label getLabel();

        @Override
        public Label processText(String text) {
            for (String keyword : getKeywords()) { //вызывается в зависимости от типа объекта (полиморфизм)
                if (text.contains(keyword)) {
                    return getLabel(); //вызывается в зависимости от типа объекта
                }
            }
            return Label.OK;
        }
    }


    class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    class NegativeTextAnalyzer extends KeywordAnalyzer {
        private String[] keywords = {":(", "=(", ":|"};

        public NegativeTextAnalyzer() {
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
        }
    }

    /**
     * Метод checkLabels, который будет возвращать метку для комментария по набору анализаторов текста. checkLabels должен возвращать первую не-OK метку в порядке данного набора анализаторов, и OK, если все анализаторы вернули OK.
     * @param analyzers
     * @param text
     * @return
     */
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label label;
        for (TextAnalyzer analyzer : analyzers) {
            label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }
        return Label.OK;
    }
//Stepik code: end
}
