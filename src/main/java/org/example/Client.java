package org.example;
import java.io.*;//импорт пакета, содержащего классы для/ ввода/вывода
import java.net.*;//импорт пакета, содержащего классы для
import java.util.Scanner;

public class Client {

    public static void main(String[] arg)
    {
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1",2525);//установление //соединения между локальной машиной и указанным портом узла сети
            System.out.println("connection established....");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));//создание//буферизированного символьного потока ввода
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание//потока вывода
            ObjectInputStream  cois = new ObjectInputStream(clientSocket.getInputStream());//создание//потока ввода
            //System.out.println("Enter any string to send to server \n\t('quite' − programme terminate)");
            //String clientMessage = stdin.readLine();
            // System.out.println("you've entered: "+clientMessage);
            // while(!clientMessage.equals("quite")) {//выполнение цикла, пока строка //не будет равна «quite»

            //  coos.writeObject(clientMessage);//потоку вывода присваивается //значение строковой переменной (передается серверу)
            //   System.out.println("~server~: "+cois.readObject());//выводится на //экран со-держимое потока ввода (переданное сервером)
            //   System.out.println("---------------------------");
            //    clientMessage = stdin.readLine();//ввод текста с клавиатуры
            //      System.out.println("you've entered: "+clientMessage);//вывод в
//консоль строки и значения строковой переменной
            // }
            Array array=new Array();
            Menu.PrintMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Сhoose an action:");
            int choice = scanner.nextInt();
            while(choice!=-1)
            {
                switch (choice) {
                    case  (1), (2):
                        array.SetArray( scanner);
                        array.PrintArray("Matrix");
                        Menu.PrintMenu();
                        System.out.print("Сhoose an action:");
                        choice = scanner.nextInt();
                        break;
                    case (3):
                        array.SendMatrixToServer(coos);
                        array.GetMatrixFromServer(cois);
                        array.PrintArray("Inverse matrix");
                        Menu.PrintMenu();
                        System.out.print("Сhoose an action:");
                        choice = scanner.nextInt();
                        break;
                    case (-1):
                        break;
                    default:
                        System.out.println("Input Error. Try again");
                        Menu.PrintMenu();
                        System.out.print("Сhoose an action:");
                        choice = scanner.nextInt();
                        break;
                }
            }
            System.out.println("You exit from system. Goodbye");
            scanner.close();
            coos.close();//закрытие потока вывода
            cois.close();//закрытие потока ввода
            clientSocket.close();//закрытие сокета
        }catch(Exception e)	{
            e.printStackTrace();//выполнение метода исключения е
        }
    }

}