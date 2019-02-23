class Main {
    //Stepik code: start

    /**
     * На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y. Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)
     *
     * В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз, направо или налево. Ваша задача — привести робота в заданную точку игрового поля.
     * @param robot
     * @param toX
     * @param toY
     */
    public static void moveRobot(Robot robot, int toX, int toY) {
        while (robot.getX() != toX) {
            while (robot.getDirection() != (toX > 0 ? Direction.RIGHT : Direction.LEFT)) {
                robot.turnLeft();
            }
            robot.stepForward();
        }

        while (robot.getY() != toY) {
            while (robot.getDirection() != (toY > 0 ? Direction.UP : Direction.DOWN)) {
                robot.turnLeft();
            }
            robot.stepForward();
        }
    }
//Stepik code: end
}
