class Main {
    //Stepik code: start

    /**
     * Вам дан список ролей и сценарий пьесы в виде массива строчек.
     *
     * Каждая строчка сценария пьесы дана в следующем виде:
     * Роль: текст
     *
     * Текст может содержать любые символы.
     *
     * Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового текста (см. пример). Каждая группа распечатывается в следующем виде:
     *
     * Роль:
     * i) текст
     * j) текст2
     * ...
     * ==перевод строки==
     *
     * i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует в соответствии с порядком ролей. Переводы строк между группами обязательны, переводы строк в конце текста не учитываются.
     * @param roles
     * @param textLines
     * @return
     */
    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder res = new StringBuilder();
        for (String role : roles) {
            res.append(role).append(":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")) {
                    res.append(i + 1).append(")").append(textLines[i].replaceFirst(role + ":", "")).append("\n");
                }
            }
            res.append("\n");
        }
        return res.toString();
    }
//Stepik code: end
}