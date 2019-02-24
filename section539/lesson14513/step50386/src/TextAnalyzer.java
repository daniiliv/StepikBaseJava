// Don't edit this file
/**
 * Вы решили абстрагировать фильтр в виде следующего интерфейса:
 *
 * interface TextAnalyzer {
 *     Label processText(String text);
 * }
 * Label – тип-перечисление, которые содержит метки, которыми будем помечать текст:
 *
 *
 * @author meanmail
 */
public interface TextAnalyzer {
    Label processText(String text);
}
