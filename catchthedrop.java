package ru.geekbrains.catch_the_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame{ // класс main переименовали в GameWindow, и наследуем его от класса JFrame стандартной библиотеки swing

    private static GameWindow game_window; // Объявляем новую переменную game_window, в которой будем хранить объект нашего окна
    private static long last_frame_time; // Переменная для подсчета времени между кадрами
    private static Image background; // Объявим переменные класса Image, который предназначен для работы с изображениями
    private static Image gameover;
    private static Image drop;
    private static float drop_left = 200; //координата Х левого верхненго угла капли
    private static float drop_top = -100; //координата Y левого верхненго угла капли
    private static float drop_v = 200; // скорость движения капли пикселей/сек



    public static void main(String[] args) throws IOException { // вынесем обработку исключения в сигнатуру метода
    // Загрузим изображения из файлов в переменные при помощи метода read класса ImageIO стандартной библиотеки imageio
        background = ImageIO.read(GameWindow.class.getResource("background.png"));
        gameover = ImageIO.read(GameWindow.class.getResource("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResource("drop.png"));

        game_window = new GameWindow(); // создаем объект окна, на который будет ссылаться переменная game_window
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // производим настройку созданного объекта
        game_window.setLocation(200,100);
        game_window.setSize(906,478);
        game_window.setResizable(false);
        last_frame_time = System.nanoTime(); // присваиваем текущее время в наносекундах для дальнейшего расчета разницы во времени при выводе кадров
        GameField game_field = new GameField(); // объявляем новую переменную game_field, создаем в ней объект класса Gamefield
        game_window.add(game_field); // добавляем созданный объект game_field в наш объект окна game_window
        game_window.setVisible(true); // делаем окно видимым

    }
// Игровой цикл реализуем в методе onRepaint:
    private static void onRepaint(Graphics g) { // создаем новый объект и передаем ему в качестве параметра объект класса Graphics стандартной библиотеки awt, назовем его g
        long current_time = System.nanoTime(); // Присваиваем текущее время
        float delta_time = (current_time - last_frame_time) * 0.000000001f ; // вычисляем разницу во времени в секундах
        last_frame_time = current_time;
        drop_top = drop_top + drop_v * delta_time;
        drop_left = drop_left + drop_v * delta_time; // Домашнее задание
        g.drawImage(background, 0, 0, null);
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);
//      g.drawImage(gameover, 280, 120, null);

    }
    private static class GameField extends JPanel { // Расовать можно на панелях, представленных классом JPanel, поэтому создаем новый класс GameField унаследовав его от класса JPanel
        @Override // переопределяем поведение стандартного метода paintComponent из класса JPanel, то есть производим динамическое замещение метода
        protected void paintComponent(Graphics g) {
            // получим доступ к стандартному методу paintComponent из класса JPanel, который отрисуем панель
            super.paintComponent(g); //и передадим ему нашу переменную g класса Graphics
            onRepaint(g);
            repaint(); //перерисовываем панель как можно чаще

        }

    }

}